// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.DatasetFolder;
import com.azure.resourcemanager.datafactory.models.LinkedServiceReference;
import com.azure.resourcemanager.datafactory.models.ParameterSpecification;
import com.azure.resourcemanager.datafactory.models.ParameterType;
import com.azure.resourcemanager.datafactory.models.SharePointOnlineListResourceDataset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class SharePointOnlineListResourceDatasetTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SharePointOnlineListResourceDataset model = BinaryData.fromString(
            "{\"type\":\"SharePointOnlineListResource\",\"typeProperties\":{\"listName\":\"datad\"},\"description\":\"mipvlxtyw\",\"structure\":\"datahj\",\"schema\":\"datapllitx\",\"linkedServiceName\":{\"referenceName\":\"rgkwiyoy\",\"parameters\":{\"sizfuewlf\":\"dataivxcodwkwoytcach\",\"gne\":\"datafiikqcdnzsfiu\",\"mcrxlyzoaho\":\"datao\",\"rnlsyiaanistc\":\"dataufakrxjjwnbrmdwt\"}},\"parameters\":{\"fa\":{\"type\":\"Float\",\"defaultValue\":\"datalpphcstmrycpana\"},\"pxngzzxqbgq\":{\"type\":\"Object\",\"defaultValue\":\"datarin\"},\"vbdozwbskueaf\":{\"type\":\"SecureString\",\"defaultValue\":\"datazctbxzjkpifpu\"}},\"annotations\":[\"datambinpxmiwt\",\"dataqi\",\"datapvrd\"],\"folder\":{\"name\":\"d\"},\"\":{\"abux\":\"datax\"}}")
            .toObject(SharePointOnlineListResourceDataset.class);
        Assertions.assertEquals("mipvlxtyw", model.description());
        Assertions.assertEquals("rgkwiyoy", model.linkedServiceName().referenceName());
        Assertions.assertEquals(ParameterType.FLOAT, model.parameters().get("fa").type());
        Assertions.assertEquals("d", model.folder().name());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SharePointOnlineListResourceDataset model = new SharePointOnlineListResourceDataset()
            .withDescription("mipvlxtyw").withStructure("datahj").withSchema("datapllitx")
            .withLinkedServiceName(new LinkedServiceReference().withReferenceName("rgkwiyoy")
                .withParameters(mapOf("sizfuewlf", "dataivxcodwkwoytcach", "gne", "datafiikqcdnzsfiu", "mcrxlyzoaho",
                    "datao", "rnlsyiaanistc", "dataufakrxjjwnbrmdwt")))
            .withParameters(mapOf("fa",
                new ParameterSpecification().withType(ParameterType.FLOAT).withDefaultValue("datalpphcstmrycpana"),
                "pxngzzxqbgq", new ParameterSpecification().withType(ParameterType.OBJECT).withDefaultValue("datarin"),
                "vbdozwbskueaf",
                new ParameterSpecification().withType(ParameterType.SECURE_STRING)
                    .withDefaultValue("datazctbxzjkpifpu")))
            .withAnnotations(Arrays.asList("datambinpxmiwt", "dataqi", "datapvrd"))
            .withFolder(new DatasetFolder().withName("d")).withListName("datad");
        model = BinaryData.fromObject(model).toObject(SharePointOnlineListResourceDataset.class);
        Assertions.assertEquals("mipvlxtyw", model.description());
        Assertions.assertEquals("rgkwiyoy", model.linkedServiceName().referenceName());
        Assertions.assertEquals(ParameterType.FLOAT, model.parameters().get("fa").type());
        Assertions.assertEquals("d", model.folder().name());
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
