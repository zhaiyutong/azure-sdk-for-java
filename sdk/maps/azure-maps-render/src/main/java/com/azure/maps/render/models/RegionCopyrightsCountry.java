// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.maps.render.models;

import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Country property. */
@Immutable
public final class RegionCopyrightsCountry {
    /*
     * ISO3 property
     */
    @JsonProperty(value = "ISO3", access = JsonProperty.Access.WRITE_ONLY)
    private String iSO3;

    /*
     * Label property
     */
    @JsonProperty(value = "label", access = JsonProperty.Access.WRITE_ONLY)
    private String label;

    /**
     * Get the label property: Label property.
     *
     * @return the label value.
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * Get the iSO3 property: ISO3 property.
     *
     * @return the iSO3 value.
     */
    public String getIso3() {
        return this.iSO3;
    }
}