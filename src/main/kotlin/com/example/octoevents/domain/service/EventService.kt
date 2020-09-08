package com.example.octoevents.domain.service

import com.example.octoevents.domain.issue.IssueEvent
import com.example.octoevents.domain.repository.IssueEventRepository
import io.javalin.http.BadRequestResponse

/**
 * Service para gerenciar eventos do tipo IssueEvent
 */
class EventService(private val respository: IssueEventRepository) {

    fun create(issueEvent: IssueEvent) {
        when {
            issueEvent.issue == null -> {
                throw BadRequestResponse("${issueEvent.issue} não pode ser nulo.")
            }
            issueEvent.repository == null -> {
                throw BadRequestResponse("${issueEvent.repository} não pode ser nulo.")
            }
        }
        this.respository.create(issueEvent)
    }

    fun findById(id: Long): IssueEvent? {
        if (id <= 0) {
            throw BadRequestResponse("${id} Deve ser maior que 0.")
        }
        return this.respository.findById(id)
    }
}