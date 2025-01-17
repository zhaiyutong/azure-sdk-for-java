// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cdn.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.cdn.models.OperationDisplay;
import com.azure.resourcemanager.cdn.models.ServiceSpecification;
import com.fasterxml.jackson.annotation.JsonProperty;

/** CDN REST API operation. */
@Fluent
public final class OperationInner {
    /*
     * Operation name: {provider}/{resource}/{operation}
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY)
    private String name;

    /*
     * Indicates whether the operation is a data action
     */
    @JsonProperty(value = "isDataAction")
    private Boolean isDataAction;

    /*
     * The object that represents the operation.
     */
    @JsonProperty(value = "display")
    private OperationDisplay display;

    /*
     * The origin of operations.
     */
    @JsonProperty(value = "origin", access = JsonProperty.Access.WRITE_ONLY)
    private String origin;

    /*
     * Properties of operation, include metric specifications.
     */
    @JsonProperty(value = "properties")
    private OperationProperties innerOperationProperties;

    /** Creates an instance of OperationInner class. */
    public OperationInner() {
    }

    /**
     * Get the name property: Operation name: {provider}/{resource}/{operation}.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Get the isDataAction property: Indicates whether the operation is a data action.
     *
     * @return the isDataAction value.
     */
    public Boolean isDataAction() {
        return this.isDataAction;
    }

    /**
     * Set the isDataAction property: Indicates whether the operation is a data action.
     *
     * @param isDataAction the isDataAction value to set.
     * @return the OperationInner object itself.
     */
    public OperationInner withIsDataAction(Boolean isDataAction) {
        this.isDataAction = isDataAction;
        return this;
    }

    /**
     * Get the display property: The object that represents the operation.
     *
     * @return the display value.
     */
    public OperationDisplay display() {
        return this.display;
    }

    /**
     * Set the display property: The object that represents the operation.
     *
     * @param display the display value to set.
     * @return the OperationInner object itself.
     */
    public OperationInner withDisplay(OperationDisplay display) {
        this.display = display;
        return this;
    }

    /**
     * Get the origin property: The origin of operations.
     *
     * @return the origin value.
     */
    public String origin() {
        return this.origin;
    }

    /**
     * Get the innerOperationProperties property: Properties of operation, include metric specifications.
     *
     * @return the innerOperationProperties value.
     */
    private OperationProperties innerOperationProperties() {
        return this.innerOperationProperties;
    }

    /**
     * Get the serviceSpecification property: One property of operation, include metric specifications.
     *
     * @return the serviceSpecification value.
     */
    public ServiceSpecification serviceSpecification() {
        return this.innerOperationProperties() == null ? null : this.innerOperationProperties().serviceSpecification();
    }

    /**
     * Set the serviceSpecification property: One property of operation, include metric specifications.
     *
     * @param serviceSpecification the serviceSpecification value to set.
     * @return the OperationInner object itself.
     */
    public OperationInner withServiceSpecification(ServiceSpecification serviceSpecification) {
        if (this.innerOperationProperties() == null) {
            this.innerOperationProperties = new OperationProperties();
        }
        this.innerOperationProperties().withServiceSpecification(serviceSpecification);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (display() != null) {
            display().validate();
        }
        if (innerOperationProperties() != null) {
            innerOperationProperties().validate();
        }
    }
}
