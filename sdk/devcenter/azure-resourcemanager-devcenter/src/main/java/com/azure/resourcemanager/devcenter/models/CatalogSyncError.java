// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devcenter.models;

import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** An individual synchronization error. */
@Immutable
public final class CatalogSyncError {
    /*
     * The path of the file the error is associated with.
     */
    @JsonProperty(value = "path", access = JsonProperty.Access.WRITE_ONLY)
    private String path;

    /*
     * Errors associated with the file.
     */
    @JsonProperty(value = "errorDetails", access = JsonProperty.Access.WRITE_ONLY)
    private List<CatalogErrorDetails> errorDetails;

    /** Creates an instance of CatalogSyncError class. */
    public CatalogSyncError() {
    }

    /**
     * Get the path property: The path of the file the error is associated with.
     *
     * @return the path value.
     */
    public String path() {
        return this.path;
    }

    /**
     * Get the errorDetails property: Errors associated with the file.
     *
     * @return the errorDetails value.
     */
    public List<CatalogErrorDetails> errorDetails() {
        return this.errorDetails;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (errorDetails() != null) {
            errorDetails().forEach(e -> e.validate());
        }
    }
}
