// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.maps.timezone;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.maps.timezone.implementation.models.ErrorResponseException;
import com.azure.maps.timezone.models.IanaId;
import com.azure.maps.timezone.models.TimezoneCoordinateOptions;
import com.azure.maps.timezone.models.TimezoneIdOptions;
import com.azure.maps.timezone.models.TimezoneIanaVersionResult;
import com.azure.maps.timezone.models.TimezoneResult;
import com.azure.maps.timezone.models.TimezoneWindows;

import java.util.List;

/**
 * {@link TimezoneClient} instances are created via the {@link TimezoneClientBuilder}, as shown below.
 * Creating a sync client using a {@link AzureKeyCredential}:
 * <!-- src_embed com.azure.maps.timezone.sync.builder.key.instantiation -->
 * <pre>
 * &#47;&#47; Authenticates using subscription key
 * AzureKeyCredential keyCredential = new AzureKeyCredential&#40;System.getenv&#40;&quot;SUBSCRIPTION_KEY&quot;&#41;&#41;;
 *
 * &#47;&#47; Creates a client
 * TimezoneClient client = new TimezoneClientBuilder&#40;&#41; 
 *     .credential&#40;keyCredential&#41;
 *     .timezoneClientId&#40;System.getenv&#40;&quot;MAPS_CLIENT_ID&quot;&#41;&#41;
 *     .buildClient&#40;&#41;;
 * </pre>
 * <!-- end com.azure.maps.timezone.sync.builder.ad.instantiation -->
 */
@ServiceClient(builder = TimezoneClientBuilder.class)
public final class TimezoneClient {
    private final TimezoneAsyncClient asyncClient;

    /**
     * Initializes an instance of TimezoneClient client.
     *
     * @param serviceClient the service client implementation.
     */
    TimezoneClient(TimezoneAsyncClient asyncClient) {
        this.asyncClient = asyncClient;
    }

    /**
     * __Time Zone by Id__
     * <!-- src_embed com.azure.maps.timezone.sync.get_timezone_by_id -->
     * <pre>
     * TimezoneIdOptions options = new TimezoneIdOptions&#40;&quot;Asia&#47;Bahrain&quot;&#41;.setOptions&#40;TimezoneOptions.ALL&#41;;
     * client.getTimezoneById&#40;options&#41;;
     * </pre>
     * <!-- end com.azure.maps.timezone.sync.get_timezone_by_id -->
     *
     * <p>**Applies to**: S0 and S1 pricing tiers.
     *
     * <p>This API returns current, historical, and future time zone information for the specified IANA time zone ID.
     *
     * @param options contains parameters for get timezone by id 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return this object is returned from a successful Timezone By ID call or By Coordinates call.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public TimezoneResult getTimezoneById(TimezoneIdOptions options) {
        return this.asyncClient.getTimezoneById(options).block();
    }

    /**
     * __Time Zone by Id__
     * <!-- src_embed com.azure.maps.timezone.sync.get_timezone_by_id -->
     * <pre>
     * TimezoneIdOptions options = new TimezoneIdOptions&#40;&quot;Asia&#47;Bahrain&quot;&#41;.setOptions&#40;TimezoneOptions.ALL&#41;;
     * client.getTimezoneById&#40;options&#41;;
     * </pre>
     * <!-- end com.azure.maps.timezone.sync.get_timezone_by_id -->
     *
     * <p>**Applies to**: S0 and S1 pricing tiers.
     *
     * <p>This API returns current, historical, and future time zone information for the specified IANA time zone ID.
     *
     * @param options contains parameters for get timezone by id 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return this object is returned from a successful Timezone By ID call or By Coordinates call.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<TimezoneResult> getTimezoneByIdWithResponse(TimezoneIdOptions options, Context context) {
        return this.asyncClient.getTimezoneByIdWithResponse(options, context).block();
    }

    /**
     * __Time Zone by Coordinates__
     * <!-- src_embed com.azure.maps.timezone.sync.get_timezone_by_coordinates -->
     * <pre>
     * GeoPosition cd = new GeoPosition&#40;-122, 47.0&#41;;
     * TimezoneCoordinateOptions op = new TimezoneCoordinateOptions&#40;cd&#41;.setTimezoneOptions&#40;TimezoneOptions.ALL&#41;;
     * client.getTimezoneByCoordinates&#40;op&#41;;
     * </pre>
     * <!-- end com.azure.maps.timezone.sync.get_timezone_by_coordinates -->
     *
     * <p>**Applies to**: S0 and S1 pricing tiers.
     *
     * <p>This API returns current, historical, and future time zone information for a specified latitude-longitude
     * pair. In addition, the API provides sunset and sunrise times for a given location.
     *
     * @param options contains parameters for get timezone by coordinates
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return this object is returned from a successful Timezone By ID call or By Coordinates call.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public TimezoneResult getTimezoneByCoordinates(TimezoneCoordinateOptions options) {
        return this.asyncClient.getTimezoneByCoordinates(options).block();
    }

    /**
     * __Time Zone by Coordinates__
     * <!-- src_embed com.azure.maps.timezone.sync.get_timezone_by_coordinates -->
     * <pre>
     * GeoPosition cd = new GeoPosition&#40;-122, 47.0&#41;;
     * TimezoneCoordinateOptions op = new TimezoneCoordinateOptions&#40;cd&#41;.setTimezoneOptions&#40;TimezoneOptions.ALL&#41;;
     * client.getTimezoneByCoordinates&#40;op&#41;;
     * </pre>
     * <!-- end com.azure.maps.timezone.sync.get_timezone_by_coordinates -->
     *
     * <p>**Applies to**: S0 and S1 pricing tiers.
     *
     * <p>This API returns current, historical, and future time zone information for a specified latitude-longitude
     * pair. In addition, the API provides sunset and sunrise times for a given location.
     *
     * @param options options contains parameters for get timezone by coordinates
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return this object is returned from a successful Timezone By ID call or By Coordinates call.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<TimezoneResult> getTimezoneByCoordinatesWithResponse(TimezoneCoordinateOptions options, Context context) {
        return this.asyncClient.getTimezoneByCoordinatesWithResponse(options, context).block();
    }

    /**
     * __Windows Time Zones__
     * <!-- src_embed com.azure.maps.timezone.sync.get_timezone_enum_windows -->
     * <pre>
     * client.getWindowsTimezoneIds&#40;&#41;;
     * </pre>
     * <!-- end com.azure.maps.timezone.sync.get_timezone_enum_windows -->
     *
     * <p>**Applies to**: S0 and S1 pricing tiers.
     *
     * <p>This API returns a full list of Windows Time Zone IDs.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return this object is returned from a successful Timezone Enum Windows call.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public List<TimezoneWindows> getWindowsTimezoneIds() {
        return this.asyncClient.getWindowsTimezoneIds().block();
    }

    /**
     * __Windows Time Zones__
     * <!-- src_embed com.azure.maps.timezone.sync.get_timezone_enum_windows -->
     * <pre>
     * client.getWindowsTimezoneIds&#40;&#41;;
     * </pre>
     * <!-- end com.azure.maps.timezone.sync.get_timezone_enum_windows -->
     *
     * <p>**Applies to**: S0 and S1 pricing tiers.
     *
     * <p>This API returns a full list of Windows Time Zone IDs.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return this object is returned from a successful Timezone Enum Windows call.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<List<TimezoneWindows>> getWindowsTimezoneIdsWithResponse(Context context) {
        return this.asyncClient.getWindowsTimezoneIdsWithResponse(context).block();
    }

    /**
     * __IANA Time Zones__
     * <!-- src_embed com.azure.maps.timezone.sync.get_timezone_enum_iana -->
     * <pre>
     * client.getIanaTimezoneIds&#40;&#41;;
     * </pre>
     * <!-- end com.azure.maps.timezone.sync.get_timezone_enum_iana -->
     *
     * <p>**Applies to**: S0 and S1 pricing tiers.
     *
     * <p>This API returns a full list of IANA time zone IDs. Updates to the IANA service will be reflected in the
     * system within one day.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return this object is returned from a successful Timezone Enum IANA call.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public List<IanaId> getIanaTimezoneIds() {
        return this.asyncClient.getIanaTimezoneIds().block();
    }

    /**
     * __IANA Time Zones__
     * <!-- src_embed com.azure.maps.timezone.sync.get_timezone_enum_iana -->
     * <pre>
     * client.getIanaTimezoneIds&#40;&#41;;
     * </pre>
     * <!-- end com.azure.maps.timezone.sync.get_timezone_enum_iana -->
     *
     * <p>**Applies to**: S0 and S1 pricing tiers.
     *
     * <p>This API returns a full list of IANA time zone IDs. Updates to the IANA service will be reflected in the
     * system within one day.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return this object is returned from a successful Timezone Enum IANA call.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<List<IanaId>> getIanaTimezoneIdsWithResponse(Context context) {
        return this.asyncClient.getIanaTimezoneIdsWithResponse(context).block();
    }

    /**
     * __Time Zone IANA Version__
     * <!-- src_embed com.azure.maps.timezone.sync.get_timezone_iana_version -->
     * <pre>
     * client.getIanaVersion&#40;&#41;;
     * </pre>
     * <!-- end com.azure.maps.timezone.sync.get_timezone_iana_version -->
     *
     * <p>**Applies to**: S0 and S1 pricing tiers.
     *
     * <p>This API returns the current IANA version number as Metadata.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return this object is returned from a successful Timezone IANA Version call.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public TimezoneIanaVersionResult getIanaVersion() {
        return this.asyncClient.getIanaVersion().block();
    }

    /**
     * __Time Zone IANA Version__
     * <!-- src_embed com.azure.maps.timezone.sync.get_timezone_iana_version -->
     * <pre>
     * client.getIanaVersion&#40;&#41;;
     * </pre>
     * <!-- end com.azure.maps.timezone.sync.get_timezone_iana_version -->
     *
     * <p>**Applies to**: S0 and S1 pricing tiers.
     *
     * <p>This API returns the current IANA version number as Metadata.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return this object is returned from a successful Timezone IANA Version call.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<TimezoneIanaVersionResult> getIanaVersionWithResponse(Context context) {
        return this.asyncClient.getIanaVersionWithResponse(context).block();
    }

    /**
     * __Windows to IANA Time Zone__
     * <!-- src_embed com.azure.maps.timezone.sync.convert_windows_timezone_to_iana -->
     * <pre>
     * client.convertWindowsTimezoneToIana&#40;&quot;pacific standard time&quot;, null&#41;;
     * </pre>
     * <!-- end com.azure.maps.timezone.sync.convert_windows_timezone_to_iana -->
     *
     * <p>**Applies to**: S0 and S1 pricing tiers.
     *
     * <p>This API returns a corresponding IANA ID, given a valid Windows Time Zone ID. Multiple IANA IDs may be
     * returned for a single Windows ID. It is possible to narrow these results by adding an optional territory
     * parameter.
     *
     * @param windowsTimezoneId The Windows time zone ID.
     * @param windowsTerritoryCode Windows Time Zone territory code.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return this object is returned from a successful Timezone Windows To IANA call.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public List<IanaId> convertWindowsTimezoneToIana(String windowsTimezoneId, String windowsTerritoryCode) {
        return this.asyncClient.convertWindowsTimezoneToIana(windowsTimezoneId, windowsTerritoryCode).block();
    }

     /**
     * __Windows to IANA Time Zone__
     * <!-- src_embed com.azure.maps.timezone.sync.convert_windows_timezone_to_iana -->
     * <pre>
     * client.convertWindowsTimezoneToIana&#40;&quot;pacific standard time&quot;, null&#41;;
     * </pre>
     * <!-- end com.azure.maps.timezone.sync.convert_windows_timezone_to_iana -->
     *
     * <p>**Applies to**: S0 and S1 pricing tiers.
     *
     * <p>This API returns a corresponding IANA ID, given a valid Windows Time Zone ID. Multiple IANA IDs may be
     * returned for a single Windows ID. It is possible to narrow these results by adding an optional territory
     * parameter.
     *
     * @param context The context to associate with this operation.
     * @param windowsTimezoneId The Windows time zone ID.
     * @param windowsTerritoryCode Windows Time Zone territory code.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return this object is returned from a successful Timezone Windows To IANA call.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<List<IanaId>> convertWindowsTimezoneToIanaWithResponse(String windowsTimezoneId, String windowsTerritoryCode, Context context) {
        return this.asyncClient.convertWindowsTimezoneToIanaWithResponse(windowsTimezoneId, windowsTerritoryCode, context).block();
    }
}