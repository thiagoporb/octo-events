package com.example.octoevents.config

import com.example.octoevents.domain.repository.IssueEventRepository
import com.example.octoevents.domain.service.EventService
import com.example.octoevents.web.Router
import com.example.octoevents.web.controller.WebhookController
import org.koin.dsl.module

object ModulesConfig {

    private val webhookModule = module {
        single {
            DatabaseConfig(getProperty("jdbc.url"), getProperty("db.username"), getProperty("db.password")).getDataSource()
        }
        single { Router(get()) }
        single { WebhookController(get()) }
        single { EventService(get()) }
        single { IssueEventRepository(get()) }
    }

    internal val allModules = listOf(webhookModule)
}