package com.example.octoevents.web.dto.issue

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

import com.example.octoevents.web.dto.issue.Issue
import com.example.octoevents.web.dto.issue.Changes

@JsonInclude(JsonInclude.Include.NON_NULL)
data class IssueEventDTO(
    @JsonProperty("action") var action: String? = null,
    @JsonProperty("issue") var issue:  Issue? = null,
    @JsonProperty("changes") var changes:  Changes? = null,
    @JsonProperty("repository") var repository:  Repository? = null,
    @JsonProperty("sender") var sender:  Sender? = null
)