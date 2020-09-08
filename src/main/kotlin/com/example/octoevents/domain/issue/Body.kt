package com.example.octoevents.domain.issue

import com.fasterxml.jackson.annotation.JsonProperty

data class Body(@JsonProperty("from") val from: String)