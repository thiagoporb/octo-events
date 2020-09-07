package com.example.octoevents.domain.issue

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class IssueEvent(
    @JsonProperty("id") var id: Long,
    @JsonProperty("action") var action: String? = null,
    @JsonProperty("issue") var issue: Issue? = null,
    @JsonProperty("changes") var changes: Change? = null,
    @JsonProperty("repository") var repository: Repository? = null,
    @JsonProperty("sender") var sender: Sender? = null
)