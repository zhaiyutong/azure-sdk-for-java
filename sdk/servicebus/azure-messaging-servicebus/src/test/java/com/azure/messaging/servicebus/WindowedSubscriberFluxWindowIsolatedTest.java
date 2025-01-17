// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.servicebus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.Isolated;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.scheduler.VirtualTimeScheduler;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.azure.messaging.servicebus.WindowedSubscriber.EnqueueResult;
import com.azure.messaging.servicebus.WindowedSubscriber.WindowedSubscriberOptions;
import com.azure.messaging.servicebus.WindowedSubscriber.WindowWork;

import static com.azure.messaging.servicebus.WindowedSubscriberFluxWindowTest.createSubscriber;
import static com.azure.messaging.servicebus.WindowedSubscriberFluxWindowTest.Upstream;

@Execution(ExecutionMode.SAME_THREAD)
@Isolated
public final class WindowedSubscriberFluxWindowIsolatedTest {
    @Test
    @Execution(ExecutionMode.SAME_THREAD)
    public void shouldCloseEmptyWindowOnTimeout() {
        final int windowSize = 10;
        final Duration windowTimeout = Duration.ofSeconds(20);
        final Upstream<Integer> upstream = new Upstream<>();

        final WindowedSubscriber<Integer> subscriber = createSubscriber();
        upstream.subscribe(subscriber);

        final AtomicReference<EnqueueResult<Integer>> rRef = new AtomicReference<>();
        final Supplier<Publisher<Integer>> scenario =  () -> {
            final EnqueueResult<Integer> r = subscriber.enqueueRequestImpl(windowSize, windowTimeout);
            rRef.set(r);
            return r.getWindowFlux();
        };

        try (VirtualTimeStepVerifier verifier = new VirtualTimeStepVerifier()) {
            verifier.create(scenario)
                // Forward time to timeout empty windowTimeout.
                .thenAwait(windowTimeout.plusSeconds(10))
                .expectNextCount(0)
                .verifyComplete();
        }

        final WindowWork<Integer> work = rRef.get().getInnerWork();
        Assertions.assertTrue(work.hasTimedOut());
        Assertions.assertFalse(work.isCanceled());
    }

    @Test
    @Execution(ExecutionMode.SAME_THREAD)
    public void shouldCloseStreamingWindowOnTimeout() {
        final int windowSize = 10;
        final Duration windowTimeout = Duration.ofSeconds(20);
        final Upstream<Integer> upstream = new Upstream<>();

        final WindowedSubscriber<Integer> subscriber = createSubscriber();
        upstream.subscribe(subscriber);

        final AtomicReference<EnqueueResult<Integer>> rRef = new AtomicReference<>();
        final Supplier<Publisher<Integer>> scenario =  () -> {
            final EnqueueResult<Integer> r = subscriber.enqueueRequestImpl(windowSize, windowTimeout);
            rRef.set(r);
            return r.getWindowFlux();
        };

        try (VirtualTimeStepVerifier verifier = new VirtualTimeStepVerifier()) {
            verifier.create(scenario)
                .then(() -> upstream.next(1))
                .then(() -> upstream.next(2))
                .expectNext(1, 2)
                // Forward time to timeout windowFlux that received fewer than demanded elements.
                .thenAwait(windowTimeout.plusSeconds(10))
                .expectNextCount(0)
                .verifyComplete();
        }

        final WindowWork<Integer> work = rRef.get().getInnerWork();
        Assertions.assertTrue(work.hasTimedOut());
        Assertions.assertFalse(work.isCanceled());
    }

    @Test
    @Execution(ExecutionMode.SAME_THREAD)
    public void shouldContinueToNextWindowWhenEmptyWindowTimeout() {
        final int windowSize = 10;
        final Duration windowTimeout = Duration.ofSeconds(20);
        final Upstream<Integer> upstream = new Upstream<>();

        final WindowedSubscriber<Integer> subscriber = createSubscriber();
        upstream.subscribe(subscriber);

        final AtomicReference<EnqueueResult<Integer>> r0Ref = new AtomicReference<>();
        final AtomicReference<EnqueueResult<Integer>> r1Ref = new AtomicReference<>();
        final Supplier<Publisher<Integer>> scenario =  () -> {
            final EnqueueResult<Integer> r0 = subscriber.enqueueRequestImpl(windowSize, windowTimeout);
            final EnqueueResult<Integer> r1 = subscriber.enqueueRequestImpl(windowSize, windowTimeout);
            r0Ref.set(r0);
            r1Ref.set(r1);
            final Flux<Integer> window0Flux = r0.getWindowFlux();
            final Flux<Integer> window1Flux = r1.getWindowFlux();
            return window0Flux.concatWith(window1Flux);
        };

        try (VirtualTimeStepVerifier verifier = new VirtualTimeStepVerifier()) {
            verifier.create(scenario)
                // Forward time to timeout empty window0Flux,
                .thenAwait(windowTimeout.plusSeconds(10))
                .then(() -> upstream.next(1))
                .then(() -> upstream.next(2))
                // then assert events from window1Flux.
                .expectNext(1, 2)
                .thenAwait(windowTimeout.plusSeconds(10))
                .expectNextCount(0)
                .verifyComplete();
        }

        final WindowWork<Integer> work0 = r0Ref.get().getInnerWork();
        Assertions.assertEquals(windowSize, work0.getPending());
        Assertions.assertTrue(work0.hasTimedOut());
        Assertions.assertFalse(work0.isCanceled());

        final WindowWork<Integer> work1 = r1Ref.get().getInnerWork();
        Assertions.assertNotEquals(windowSize, work1.getPending());
        Assertions.assertTrue(work1.hasTimedOut());
        Assertions.assertFalse(work1.isCanceled());
    }

    @Test
    @Execution(ExecutionMode.SAME_THREAD)
    public void shouldContinueToNextWindowWhenStreamingWindowTimeout() {
        final int windowSize = 10;
        final Duration windowTimeout = Duration.ofSeconds(20);
        final Upstream<Integer> upstream = new Upstream<>();

        final WindowedSubscriber<Integer> subscriber = createSubscriber();
        upstream.subscribe(subscriber);

        final AtomicReference<EnqueueResult<Integer>> r0Ref = new AtomicReference<>();
        final AtomicReference<EnqueueResult<Integer>> r1Ref = new AtomicReference<>();
        final Supplier<Publisher<Integer>> scenario =  () -> {
            final EnqueueResult<Integer> r0 = subscriber.enqueueRequestImpl(windowSize, windowTimeout);
            final EnqueueResult<Integer> r1 = subscriber.enqueueRequestImpl(windowSize, windowTimeout);
            r0Ref.set(r0);
            r1Ref.set(r1);
            final Flux<Integer> window0Flux = r0.getWindowFlux();
            final Flux<Integer> window1Flux = r1.getWindowFlux();
            return window0Flux.concatWith(window1Flux);
        };

        try (VirtualTimeStepVerifier verifier = new VirtualTimeStepVerifier()) {
            verifier.create(scenario)
                .then(() -> upstream.next(1))
                .then(() -> upstream.next(2))
                .expectNext(1, 2)
                // Forward time to timeout window0Flux that received fewer than demanded elements,
                .thenAwait(windowTimeout.plusSeconds(10))
                // then assert events from window1Flux.
                .then(() -> upstream.next(3))
                .then(() -> upstream.next(4))
                .expectNext(3, 4)
                .thenAwait(windowTimeout.plusSeconds(10))
                .expectNextCount(0)
                .verifyComplete();
        }

        final WindowWork<Integer> work0 = r0Ref.get().getInnerWork();
        Assertions.assertNotEquals(windowSize, work0.getPending());
        Assertions.assertTrue(work0.hasTimedOut());
        Assertions.assertFalse(work0.isCanceled());

        final WindowWork<Integer> work1 = r1Ref.get().getInnerWork();
        Assertions.assertNotEquals(windowSize, work1.getPending());
        Assertions.assertTrue(work1.hasTimedOut());
        Assertions.assertFalse(work1.isCanceled());
    }

    @Test
    @Execution(ExecutionMode.SAME_THREAD)
    public void shouldContinueToNextWindowWhenStreamingWindowCancels() {
        final int windowSize = 50;
        final int cancelAfter = 2;
        final Duration windowTimeout = Duration.ofSeconds(20);
        final Upstream<Integer> upstream = new Upstream<>();

        final WindowedSubscriber<Integer> subscriber = createSubscriber();
        upstream.subscribe(subscriber);

        final AtomicReference<EnqueueResult<Integer>> r0Ref = new AtomicReference<>();
        final AtomicReference<EnqueueResult<Integer>> r1Ref = new AtomicReference<>();
        final Supplier<Publisher<Integer>> scenario =  () -> {
            final EnqueueResult<Integer> r0 = subscriber.enqueueRequestImpl(windowSize, windowTimeout);
            final EnqueueResult<Integer> r1 = subscriber.enqueueRequestImpl(windowSize, windowTimeout);
            r0Ref.set(r0);
            r1Ref.set(r1);
            final Flux<Integer> window0Flux = r0.getWindowFlux();
            final Flux<Integer> window1Flux = r1.getWindowFlux();
            return window0Flux
                .take(cancelAfter)
                .concatWith(window1Flux);
        };

        try (VirtualTimeStepVerifier verifier = new VirtualTimeStepVerifier()) {
            verifier.create(scenario)
                .then(() -> upstream.next(1))
                .then(() -> upstream.next(2))
                .then(() -> upstream.next(3))
                .expectNext(1, 2) // window0Flux cancels here
                .thenAwait(windowTimeout.plusSeconds(10))
                .thenConsumeWhile(v -> true)
                .verifyComplete();
        }

        final WindowWork<Integer> work0 = r0Ref.get().getInnerWork();
        Assertions.assertNotEquals(windowSize, work0.getPending());
        Assertions.assertTrue(work0.isCanceled());
        Assertions.assertFalse(work0.hasTimedOut());

        final WindowWork<Integer> work1 = r1Ref.get().getInnerWork();
        Assertions.assertTrue(work1.hasTimedOut());
        Assertions.assertFalse(work1.isCanceled());
    }

    @Test
    @Execution(ExecutionMode.SAME_THREAD)
    public void shouldRequestWindowDemand() {
        final int windowSize = 50;
        final Duration windowTimeout = Duration.ofSeconds(20);
        final Upstream<Integer> upstream = new Upstream<>();

        final WindowedSubscriber<Integer> subscriber = createSubscriber();
        upstream.subscribe(subscriber);

        final AtomicReference<EnqueueResult<Integer>> rRef = new AtomicReference<>();
        final Supplier<Publisher<Integer>> scenario =  () -> {
            final EnqueueResult<Integer> r = subscriber.enqueueRequestImpl(windowSize, windowTimeout);
            rRef.set(r);
            return r.getWindowFlux();
        };

        try (VirtualTimeStepVerifier verifier = new VirtualTimeStepVerifier()) {
            verifier.create(scenario)
                .thenAwait(windowTimeout.plusSeconds(10))
                .verifyComplete();
        }
        Assertions.assertEquals(windowSize, upstream.getRequested());

        final WindowWork<Integer> work = rRef.get().getInnerWork();
        Assertions.assertTrue(work.hasTimedOut());
        Assertions.assertFalse(work.isCanceled());
    }

    @Test
    @Execution(ExecutionMode.SAME_THREAD)
    public void shouldAccountPendingRequestWhenServingNextWindowDemand() {
        final int window0Size = 10;
        final int window1Size = 25;
        final Duration windowTimeout = Duration.ofSeconds(20);
        final Upstream<Integer> upstream = new Upstream<>();

        final WindowedSubscriber<Integer> subscriber = createSubscriber();
        upstream.subscribe(subscriber);

        final AtomicReference<EnqueueResult<Integer>> r0Ref = new AtomicReference<>();
        final AtomicReference<EnqueueResult<Integer>> r1Ref = new AtomicReference<>();
        final Supplier<Publisher<Integer>> scenario =  () -> {
            final EnqueueResult<Integer> r0 = subscriber.enqueueRequestImpl(window0Size, windowTimeout);
            final EnqueueResult<Integer> r1 = subscriber.enqueueRequestImpl(window1Size, windowTimeout);
            r0Ref.set(r0);
            r1Ref.set(r1);
            final Flux<Integer> window0Flux = r0.getWindowFlux();
            final Flux<Integer> window1Flux = r1.getWindowFlux();
            return window0Flux.concatWith(window1Flux);
        };


        try (VirtualTimeStepVerifier verifier = new VirtualTimeStepVerifier()) {
            verifier.create(scenario)
                // timeout window0Flux without receiving (so pending request become 'windowSize0'), and pick next work.
                .thenAwait(windowTimeout.plusSeconds(10))
                // timeout window1Flux without receiving.
                .thenAwait(windowTimeout.plusSeconds(10))
                .verifyComplete();
        }
        Assertions.assertEquals(window0Size + (window1Size - window0Size), upstream.getRequested());

        final WindowWork<Integer> work0 = r0Ref.get().getInnerWork();
        Assertions.assertTrue(work0.hasTimedOut());
        Assertions.assertFalse(work0.isCanceled());

        final WindowWork<Integer> work1 = r1Ref.get().getInnerWork();
        Assertions.assertTrue(work1.hasTimedOut());
        Assertions.assertFalse(work1.isCanceled());
    }

    @Test
    @Execution(ExecutionMode.SAME_THREAD)
    public void shouldPickEnqueuedWindowRequestsOnSubscriptionReady() {
        final int window0Size = 1;
        final int window1Size = 3;
        final Duration windowTimeout = Duration.ofSeconds(20);
        final Upstream<Integer> upstream = new Upstream<>();

        final WindowedSubscriber<Integer> subscriber = createSubscriber();
        upstream.subscribe(subscriber);

        final AtomicReference<EnqueueResult<Integer>> r0Ref = new AtomicReference<>();
        final AtomicReference<EnqueueResult<Integer>> r1Ref = new AtomicReference<>();
        final Supplier<Publisher<Integer>> scenario =  () -> {
            final EnqueueResult<Integer> r0 = subscriber.enqueueRequestImpl(window0Size, windowTimeout);
            final EnqueueResult<Integer> r1 = subscriber.enqueueRequestImpl(window1Size, windowTimeout);
            r0Ref.set(r0);
            r1Ref.set(r1);
            final Flux<Integer> window0Flux = r0.getWindowFlux();
            final Flux<Integer> window1Flux = r1.getWindowFlux();
            return window0Flux.concatWith(window1Flux);
        };

        try (VirtualTimeStepVerifier verifier = new VirtualTimeStepVerifier()) {
            verifier.create(scenario)
                // subscribe after enqueuing requests in 'scenario' (mimicking late arrival of subscription).
                .then(() -> upstream.subscribe(subscriber))
                .then(() -> upstream.next(1))
                // window0Flux closes here as it received it's demanded.
                .expectNext(1)
                // forward time to timeout window1Flux without receiving.
                .thenAwait(windowTimeout.plusSeconds(10))
                .verifyComplete();
        }

        final WindowWork<Integer> work0 = r0Ref.get().getInnerWork();
        Assertions.assertTrue(work0.hasReceivedDemanded());
        Assertions.assertFalse(work0.hasTimedOut());
        Assertions.assertFalse(work0.isCanceled());

        final WindowWork<Integer> work1 = r1Ref.get().getInnerWork();
        Assertions.assertTrue(work1.hasTimedOut());
        Assertions.assertFalse(work1.isCanceled());
    }

    @Test
    @Execution(ExecutionMode.SAME_THREAD)
    public void shouldInvokeReleaserWhenNoWindowToService() {
        final int windowSize = 10;
        final Duration windowTimeout = Duration.ofSeconds(20);
        final Releaser<Integer> releaser = new Releaser<>();
        final Upstream<Integer> upstream = new Upstream<>();

        final WindowedSubscriberOptions<Integer> options = new WindowedSubscriberOptions<>();
        final WindowedSubscriber<Integer> subscriber = createSubscriber(options.setReleaser(releaser));
        upstream.subscribe(subscriber);

        final AtomicReference<EnqueueResult<Integer>> rRef = new AtomicReference<>();
        final Supplier<Publisher<Integer>> scenario =  () -> {
            final EnqueueResult<Integer> r = subscriber.enqueueRequestImpl(windowSize, windowTimeout);
            rRef.set(r);
            return r.getWindowFlux();
        };

        try (VirtualTimeStepVerifier verifier = new VirtualTimeStepVerifier()) {
            verifier.create(scenario)
                // forward time to timeout windowFlux without receiving.
                .thenAwait(windowTimeout.plusSeconds(10))
                .verifyComplete();
        }

        upstream.next(1);
        upstream.next(2);
        upstream.next(3);

        final List<Integer> released = releaser.getReleased();
        Assertions.assertEquals(Arrays.asList(1, 2, 3), released);
    }

    @Test
    @Execution(ExecutionMode.SAME_THREAD)
    public void shouldStopInvokingReleaserOnUpstreamTermination() {
        final int windowSize = 10;
        final Duration windowTimeout = Duration.ofSeconds(20);
        final Releaser<Integer> releaser = new Releaser<>();
        final Upstream<Integer> upstream = new Upstream<>();

        final WindowedSubscriberOptions<Integer> options = new WindowedSubscriberOptions<>();
        final WindowedSubscriber<Integer> subscriber = createSubscriber(options.setReleaser(releaser));
        upstream.subscribe(subscriber);

        final AtomicReference<EnqueueResult<Integer>> rRef = new AtomicReference<>();
        final Supplier<Publisher<Integer>> scenario =  () -> {
            final EnqueueResult<Integer> r = subscriber.enqueueRequestImpl(windowSize, windowTimeout);
            rRef.set(r);
            return r.getWindowFlux();
        };

        try (VirtualTimeStepVerifier verifier = new VirtualTimeStepVerifier()) {
            verifier.create(scenario)
                // forward time to timeout windowFlux without receiving.
                .thenAwait(windowTimeout.plusSeconds(10))
                .verifyComplete();
        }

        upstream.next(1);
        upstream.next(2);
        upstream.complete();
        upstream.next(3);
        upstream.next(3);

        final List<Integer> released = releaser.getReleased();
        Assertions.assertEquals(Arrays.asList(1, 2), released);
    }

    private static final class VirtualTimeStepVerifier implements AutoCloseable {
        private final VirtualTimeScheduler scheduler;

        VirtualTimeStepVerifier() {
            scheduler = VirtualTimeScheduler.create();
        }

        <T> StepVerifier.Step<T> create(Supplier<Publisher<T>> scenarioSupplier) {
            return StepVerifier.withVirtualTime(scenarioSupplier, () -> scheduler, Integer.MAX_VALUE);
        }

        @Override
        public void close() {
            scheduler.dispose();
        }
    }

    private static class Releaser<T> implements Consumer<T> {
        private final Deque<T> released = new ConcurrentLinkedDeque<>();

        @Override
        public void accept(T v) {
            released.add(v);
        }

        List<T> getReleased() {
            return new ArrayList<>(released);
        }
    }
}
