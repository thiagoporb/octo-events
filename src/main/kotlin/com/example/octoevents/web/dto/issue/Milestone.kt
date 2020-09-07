package com.example.octoevents.web.dto.issue

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty


@JsonInclude(JsonInclude.Include.NON_NULL)
data class Milestone(
    @JsonProperty("url") var url: String? = null,
    @JsonProperty("html_url") var htmlUrl: String? = null,
    @JsonProperty("labels_url") var labelsUrl: String? = null,
    @JsonProperty("id") var id: Long? = null,
    @JsonProperty("node_id") var nodeId: String? = null,
    @JsonProperty("number") var number: Long? = null,
    @JsonProperty("title") var title: String? = null,
    @JsonProperty("description") var description: String? = null,
    @JsonProperty("creator") var creator:  Creator? = null,
    @JsonProperty("open_issues") var openIssues: Long? = null,
    @JsonProperty("closed_issues") var closedIssues: Long? = null,
    @JsonProperty("state") var state: String? = null,
    @JsonProperty("created_at") var createdAt: String? = null,
    @JsonProperty("updated_at") var updatedAt: String? = null,
    @JsonProperty("due_on") var dueOn: String? = null,
    @JsonProperty("closed_at") var closedAt: String? = null
)