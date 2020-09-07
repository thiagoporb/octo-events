package com.example.octoevents.domain.issue

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty


@JsonInclude(JsonInclude.Include.NON_NULL)
data class Issue(
    @JsonProperty("url") var url: String? = null,
    @JsonProperty("repository_url") var repositoryUrl: String? = null,
    @JsonProperty("labels_url") var labelsUrl: String? = null,
    @JsonProperty("comments_url") var commentsUrl: String? = null,
    @JsonProperty("events_url") var eventsUrl: String? = null,
    @JsonProperty("html_url") var htmlUrl: String? = null,
    @JsonProperty("id") val id: Long,
    @JsonProperty("node_id") var nodeId: String? = null,
    @JsonProperty("number") var number: Long? = null,
    @JsonProperty("title") var title: String? = null,
    @JsonProperty("user") var user: User? = null,
    @JsonProperty("labels") var labels: MutableList<Label>? = null,
    @JsonProperty("state") var state: String? = null,
    @JsonProperty("locked") var locked: Boolean? = null,
    @JsonProperty("assignee") var assignee: Assignee? = null,
    @JsonProperty("assignees") var assignees: MutableList<Assignee>? = null,
    @JsonProperty("milestone") var milestone: Milestone? = null,
    @JsonProperty("comments") var comments: Long? = null,
    @JsonProperty("created_at") var createdAt: String? = null,
    @JsonProperty("updated_at") var updatedAt: String? = null,
    @JsonProperty("closed_at") var closedAt: String? = null,
    @JsonProperty("author_association") var authorAssociation: String? = null,
    @JsonProperty("body") var body: String? = null
)