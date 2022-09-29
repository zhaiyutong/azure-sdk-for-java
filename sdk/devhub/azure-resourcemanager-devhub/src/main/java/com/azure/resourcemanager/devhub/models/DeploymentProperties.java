// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devhub.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/** The DeploymentProperties model. */
@Fluent
public final class DeploymentProperties {
    /*
     * Determines the type of manifests within the repository.
     */
    @JsonProperty(value = "manifestType")
    private ManifestType manifestType;

    /*
     * The kubeManifestLocations property.
     */
    @JsonProperty(value = "kubeManifestLocations")
    private List<String> kubeManifestLocations;

    /*
     * Helm chart directory path in repository.
     */
    @JsonProperty(value = "helmChartPath")
    private String helmChartPath;

    /*
     * Helm Values.yaml file location in repository.
     */
    @JsonProperty(value = "helmValues")
    private String helmValues;

    /*
     * Manifest override values.
     */
    @JsonProperty(value = "overrides")
    @JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.ALWAYS)
    private Map<String, String> overrides;

    /**
     * Get the manifestType property: Determines the type of manifests within the repository.
     *
     * @return the manifestType value.
     */
    public ManifestType manifestType() {
        return this.manifestType;
    }

    /**
     * Set the manifestType property: Determines the type of manifests within the repository.
     *
     * @param manifestType the manifestType value to set.
     * @return the DeploymentProperties object itself.
     */
    public DeploymentProperties withManifestType(ManifestType manifestType) {
        this.manifestType = manifestType;
        return this;
    }

    /**
     * Get the kubeManifestLocations property: The kubeManifestLocations property.
     *
     * @return the kubeManifestLocations value.
     */
    public List<String> kubeManifestLocations() {
        return this.kubeManifestLocations;
    }

    /**
     * Set the kubeManifestLocations property: The kubeManifestLocations property.
     *
     * @param kubeManifestLocations the kubeManifestLocations value to set.
     * @return the DeploymentProperties object itself.
     */
    public DeploymentProperties withKubeManifestLocations(List<String> kubeManifestLocations) {
        this.kubeManifestLocations = kubeManifestLocations;
        return this;
    }

    /**
     * Get the helmChartPath property: Helm chart directory path in repository.
     *
     * @return the helmChartPath value.
     */
    public String helmChartPath() {
        return this.helmChartPath;
    }

    /**
     * Set the helmChartPath property: Helm chart directory path in repository.
     *
     * @param helmChartPath the helmChartPath value to set.
     * @return the DeploymentProperties object itself.
     */
    public DeploymentProperties withHelmChartPath(String helmChartPath) {
        this.helmChartPath = helmChartPath;
        return this;
    }

    /**
     * Get the helmValues property: Helm Values.yaml file location in repository.
     *
     * @return the helmValues value.
     */
    public String helmValues() {
        return this.helmValues;
    }

    /**
     * Set the helmValues property: Helm Values.yaml file location in repository.
     *
     * @param helmValues the helmValues value to set.
     * @return the DeploymentProperties object itself.
     */
    public DeploymentProperties withHelmValues(String helmValues) {
        this.helmValues = helmValues;
        return this;
    }

    /**
     * Get the overrides property: Manifest override values.
     *
     * @return the overrides value.
     */
    public Map<String, String> overrides() {
        return this.overrides;
    }

    /**
     * Set the overrides property: Manifest override values.
     *
     * @param overrides the overrides value to set.
     * @return the DeploymentProperties object itself.
     */
    public DeploymentProperties withOverrides(Map<String, String> overrides) {
        this.overrides = overrides;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}