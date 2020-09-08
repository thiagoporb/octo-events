package com.example.octoevents.domain.issue

import com.fasterxml.jackson.annotation.JsonProperty

data class License(
    @JsonProperty("key") var key: String? = null,
    @JsonProperty("name") var name: String? = null,
    @JsonProperty("spdx_id") var spdxId: String? = null,
    @JsonProperty("url") var url: String? = null,
    @JsonProperty("node_id") val nodeId: String
)