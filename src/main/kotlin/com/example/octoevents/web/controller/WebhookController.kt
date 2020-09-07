package com.example.octoevents.web.controller

import com.example.octoevents.domain.issue.IssueEvent
import com.example.octoevents.domain.service.EventService
import io.javalin.http.Context
import org.eclipse.jetty.http.HttpStatus
import org.slf4j.LoggerFactory

/**
 *
 */
class WebhookController(private val service: EventService) {

    private val log = LoggerFactory.getLogger(javaClass)

    /**
     *
     */
    fun create(ctx: Context) {
        ctx.bodyValidator<IssueEvent>().get().also {
            this.service.create(it).apply {
                ctx.status(HttpStatus.Code.CREATED.code)
            }
//            this.service.create(toDomain(it)).apply {
//                ctx.status(status.code)
//            }
        }
    }

    /**
     *
     */
    fun getById(ctx: Context) {
        ctx.pathParam<Long>("id")
            .get().also { id ->
                val event = this.service.findById(id)
                if (event != null) {
                    ctx.json(event)
                    //ctx.json(toDto(event))
                } else {
                    ctx.status(HttpStatus.Code.NOT_FOUND.code)
                }
            }
//        ctx.pathParam<Long>("id")
//            .get().also { id ->
//                val event = this.service.findById(id)
//                if (event != null) {
//                    ctx.json(toDto(event))
//                } else {
//                    ctx.status(HttpStatus.Code.NOT_FOUND.code)
//                }
//            }
    }

}

