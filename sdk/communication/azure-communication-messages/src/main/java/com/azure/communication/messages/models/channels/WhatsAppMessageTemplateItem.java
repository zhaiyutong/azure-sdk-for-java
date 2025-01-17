// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.communication.messages.models.channels;

import com.azure.communication.messages.models.MessageTemplateItem;
import com.azure.communication.messages.models.MessageTemplateStatus;
import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.core.util.BinaryData;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * The WhatsApp-specific template response contract.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "kind")
@JsonTypeName("whatsApp")
@Immutable
public final class WhatsAppMessageTemplateItem extends MessageTemplateItem {
    /*
     * WhatsApp platform's template content. This is the payload returned from WhatsApp API.
     */
    @Generated
    @JsonProperty(value = "content")
    private Object content;

    /**
     * Creates an instance of WhatsAppMessageTemplateItem class.
     * 
     * @param language the language value to set.
     * @param status the status value to set.
     */
    @Generated
    @JsonCreator
    private WhatsAppMessageTemplateItem(@JsonProperty(value = "language") String language,
        @JsonProperty(value = "status") MessageTemplateStatus status) {
        super(language, status);
    }

    /**
     * Get the content property: WhatsApp platform's template content. This is the payload returned from WhatsApp API.
     * 
     * @return the content value.
     */
    @Generated
    public BinaryData getContent() {
        Object returnValue = this.content;
        return BinaryData.fromObject(returnValue);
    }
}
