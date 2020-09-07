package com.example.octoevents.domain.issue

import com.fasterxml.jackson.annotation.JsonProperty

open class BaseUser(
    @JsonProperty("login") var login: String? = null,
    @JsonProperty("id") val id: Long,
    @JsonProperty("node_id") var nodeId: String? = null,
    @JsonProperty("avatar_url") var avatarUrl: String? = null,
    @JsonProperty("gravatar_id") var gravatarId: String? = null,
    @JsonProperty("url") var url: String? = null,
    @JsonProperty("html_url") var htmlUrl: String? = null,
    @JsonProperty("followers_url") var followersUrl: String? = null,
    @JsonProperty("following_url") var followingUrl: String? = null,
    @JsonProperty("gists_url") var gistsUrl: String? = null,
    @JsonProperty("starred_url") var starredUrl: String? = null,
    @JsonProperty("subscriptions_url") var subscriptionsUrl: String? = null,
    @JsonProperty("organizations_url") var organizationsUrl: String? = null,
    @JsonProperty("repos_url") var reposUrl: String? = null,
    @JsonProperty("events_url") var eventsUrl: String? = null,
    @JsonProperty("received_events_url") var receivedEventsUrl: String? = null,
    @JsonProperty("type") var type: String? = null,
    @JsonProperty("site_admin") var siteAdmin: Boolean? = null
)