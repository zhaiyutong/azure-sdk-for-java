// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.ScriptActivityParameter;
import com.azure.resourcemanager.datafactory.models.ScriptActivityParameterDirection;
import com.azure.resourcemanager.datafactory.models.ScriptActivityParameterType;
import org.junit.jupiter.api.Assertions;

public final class ScriptActivityParameterTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ScriptActivityParameter model = BinaryData.fromString(
            "{\"name\":\"datau\",\"type\":\"DateTimeOffset\",\"value\":\"datajoshmmzotcpf\",\"direction\":\"Output\",\"size\":119206096}")
            .toObject(ScriptActivityParameter.class);
        Assertions.assertEquals(ScriptActivityParameterType.DATE_TIME_OFFSET, model.type());
        Assertions.assertEquals(ScriptActivityParameterDirection.OUTPUT, model.direction());
        Assertions.assertEquals(119206096, model.size());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ScriptActivityParameter model = new ScriptActivityParameter().withName("datau")
            .withType(ScriptActivityParameterType.DATE_TIME_OFFSET).withValue("datajoshmmzotcpf")
            .withDirection(ScriptActivityParameterDirection.OUTPUT).withSize(119206096);
        model = BinaryData.fromObject(model).toObject(ScriptActivityParameter.class);
        Assertions.assertEquals(ScriptActivityParameterType.DATE_TIME_OFFSET, model.type());
        Assertions.assertEquals(ScriptActivityParameterDirection.OUTPUT, model.direction());
        Assertions.assertEquals(119206096, model.size());
    }
}
