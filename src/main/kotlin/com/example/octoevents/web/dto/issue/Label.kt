package com.example.octoevents.web.dto.issue

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
class Label(
    @JsonProperty("id") var id: Long? = null,
    @JsonProperty("node_id") var nodeId: String? = null,
    @JsonProperty("url") var url: String? = null,
    @JsonProperty("name") var name: String? = null,
    @JsonProperty("color") var color: String? = null,
    @JsonProperty("default") var _default: Boolean? = null
)