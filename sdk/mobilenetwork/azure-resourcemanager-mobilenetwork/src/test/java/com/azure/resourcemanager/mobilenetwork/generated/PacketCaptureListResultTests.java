// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mobilenetwork.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.mobilenetwork.fluent.models.PacketCaptureInner;
import com.azure.resourcemanager.mobilenetwork.models.PacketCaptureListResult;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class PacketCaptureListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PacketCaptureListResult model =
            BinaryData
                .fromString(
                    "{\"value\":[{\"properties\":{\"provisioningState\":\"Accepted\",\"status\":\"Stopped\",\"reason\":\"ovm\",\"captureStartTime\":\"2020-12-31T07:20:30Z\",\"networkInterfaces\":[\"spkwlhzdobpxjm\",\"lb\",\"vnchrkcci\",\"wzjuqk\"],\"bytesToCapturePerPacket\":1420869925986942860,\"totalBytesPerSession\":9083271895139408409,\"timeLimitInSeconds\":481973669,\"outputFiles\":[\"oskg\",\"sauuimj\",\"vxieduugidyj\",\"rfbyaosvexcso\"]},\"id\":\"clhocohsl\",\"name\":\"ev\",\"type\":\"eggzfb\"}],\"nextLink\":\"fmvfaxkffeiit\"}")
                .toObject(PacketCaptureListResult.class);
        Assertions.assertEquals("spkwlhzdobpxjm", model.value().get(0).networkInterfaces().get(0));
        Assertions.assertEquals(1420869925986942860L, model.value().get(0).bytesToCapturePerPacket());
        Assertions.assertEquals(9083271895139408409L, model.value().get(0).totalBytesPerSession());
        Assertions.assertEquals(481973669, model.value().get(0).timeLimitInSeconds());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PacketCaptureListResult model =
            new PacketCaptureListResult()
                .withValue(
                    Arrays
                        .asList(
                            new PacketCaptureInner()
                                .withNetworkInterfaces(Arrays.asList("spkwlhzdobpxjm", "lb", "vnchrkcci", "wzjuqk"))
                                .withBytesToCapturePerPacket(1420869925986942860L)
                                .withTotalBytesPerSession(9083271895139408409L)
                                .withTimeLimitInSeconds(481973669)));
        model = BinaryData.fromObject(model).toObject(PacketCaptureListResult.class);
        Assertions.assertEquals("spkwlhzdobpxjm", model.value().get(0).networkInterfaces().get(0));
        Assertions.assertEquals(1420869925986942860L, model.value().get(0).bytesToCapturePerPacket());
        Assertions.assertEquals(9083271895139408409L, model.value().get(0).totalBytesPerSession());
        Assertions.assertEquals(481973669, model.value().get(0).timeLimitInSeconds());
    }
}
