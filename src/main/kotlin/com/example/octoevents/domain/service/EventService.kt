package com.example.octoevents.domain.service

import com.example.octoevents.domain.issue.IssueEvent
import com.example.octoevents.domain.repository.IssueEventRepository

class EventService(private val respository: IssueEventRepository) {

    fun create(issueEvent: IssueEvent) {
        return this.respository.create(issueEvent)
    }

    fun findById(id: Long): IssueEvent? {
        return this.respository.findById(id)
    }
}