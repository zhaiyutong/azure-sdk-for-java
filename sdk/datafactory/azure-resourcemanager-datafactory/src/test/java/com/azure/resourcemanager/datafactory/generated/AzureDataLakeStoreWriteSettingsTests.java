// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.AzureDataLakeStoreWriteSettings;
import com.azure.resourcemanager.datafactory.models.MetadataItem;
import java.util.Arrays;

public final class AzureDataLakeStoreWriteSettingsTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AzureDataLakeStoreWriteSettings model = BinaryData.fromString(
            "{\"type\":\"AzureDataLakeStoreWriteSettings\",\"expiryDateTime\":\"datarbjxewcscuveljf\",\"maxConcurrentConnections\":\"datain\",\"disableMetricsCollection\":\"dataziztgddahymv\",\"copyBehavior\":\"datajtdhmig\",\"metadata\":[{\"name\":\"dataexgien\",\"value\":\"datasijqygofshdaehxv\"},{\"name\":\"datafdsafgkysymhuxs\",\"value\":\"datallbpegcetezaa\"},{\"name\":\"dataszrbttz\",\"value\":\"dataeyrw\"},{\"name\":\"datafgoyxxszpaiecurf\",\"value\":\"datafshfmgiixurve\"}],\"\":{\"iuwhcyckekm\":\"datasmulvmywoefkpuuu\",\"oycpotmaosongtbh\":\"datafipygt\"}}")
            .toObject(AzureDataLakeStoreWriteSettings.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AzureDataLakeStoreWriteSettings model
            = new AzureDataLakeStoreWriteSettings().withMaxConcurrentConnections("datain")
                .withDisableMetricsCollection("dataziztgddahymv").withCopyBehavior("datajtdhmig")
                .withMetadata(Arrays.asList(new MetadataItem().withName("dataexgien").withValue("datasijqygofshdaehxv"),
                    new MetadataItem().withName("datafdsafgkysymhuxs").withValue("datallbpegcetezaa"),
                    new MetadataItem().withName("dataszrbttz").withValue("dataeyrw"),
                    new MetadataItem().withName("datafgoyxxszpaiecurf").withValue("datafshfmgiixurve")))
                .withExpiryDateTime("datarbjxewcscuveljf");
        model = BinaryData.fromObject(model).toObject(AzureDataLakeStoreWriteSettings.class);
    }
}
