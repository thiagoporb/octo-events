package com.example.octoevents.web.controller

import com.example.octoevents.domain.issue.IssueEvent
import com.example.octoevents.domain.service.EventService
import io.javalin.http.Context
import org.eclipse.jetty.http.HttpStatus
import org.slf4j.LoggerFactory

/**
 * REST controller para gerenciar eventos enviados pelo Github.
 *
 * @param service - Serviço que contém a lógica de negócio do tratamento de Events.
 *
 */
class WebhookController(private val service: EventService) {

    private val LOG = LoggerFactory.getLogger(javaClass)

    /**
     * `POST  /events`  : Cria um novo evento do tipo IssueEvent.
     *
     * @return status `201 (Created)` ou `400 (Bad Request)` se o JSON for inválido ou não tiver os elementos obrigatórios.
     */
    fun create(ctx: Context) {

        LOG.info("Processando requisição do recurso [${ctx.url()}] solicitada pelo IP: [${ctx.ip()}]")

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
     * `GET  /issues/:id/events` : obtem um `IssueEvent` por id.
     *
     * @return o `IssueEvent` no corpo com status `200 (OK)`, ou status `404 (Not Found)`.
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

