// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.callautomation.models;

import com.azure.core.annotation.Immutable;

/** The locator used for joining or taking action on a call. */
@Immutable
public final class ServerCallLocator extends CallLocator {
    /*
     * The server call id
     */
    private final String serverCallId;

    /**
     * Group call locator
     *
     * @param serverCallId Specify the group call id.
     */
    public ServerCallLocator(String serverCallId) {
        super(CallLocatorKind.SERVER_CALL_LOCATOR);
        this.serverCallId = serverCallId;
    }

    /**
     * Get the serverCallId property: The server call id.
     *
     * @return the serverCallId value.
     */
    public String getServerCallId() {
        return this.serverCallId;
    }
}