// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devcenter.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.util.Context;

/** Resource collection API of Usages. */
public interface Usages {
    /**
     * Lists the current usages and limits in this location for the provided subscription.
     *
     * @param location The Azure region.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return list of Core Usages as paginated response with {@link PagedIterable}.
     */
    PagedIterable<Usage> listByLocation(String location);

    /**
     * Lists the current usages and limits in this location for the provided subscription.
     *
     * @param location The Azure region.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return list of Core Usages as paginated response with {@link PagedIterable}.
     */
    PagedIterable<Usage> listByLocation(String location, Context context);
}