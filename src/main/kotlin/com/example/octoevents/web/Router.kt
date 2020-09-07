package com.example.octoevents.web

import com.example.octoevents.web.controller.WebhookController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.apibuilder.ApiBuilder.post
import io.javalin.apibuilder.ApiBuilder.get
import org.koin.core.KoinComponent

class Router(private val webhookController: WebhookController): KoinComponent {

    fun register(app: Javalin) {
        app.routes {
            path("/events") {
                post(webhookController::create)
            }
            path("issues/:id/events") {
                get(webhookController::getById)
            }
        }
    }

}