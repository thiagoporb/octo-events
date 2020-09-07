package com.example.octoevents.web.controller

import com.example.octoevents.config.AppConfig
import com.example.octoevents.domain.issue.IssueEvent
import com.example.octoevents.web.controller.util.HttpUtil
import com.example.octoevents.web.controller.util.loadIssueEvent
import com.mashape.unirest.http.HttpResponse
import io.javalin.Javalin
import org.eclipse.jetty.http.HttpStatus
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class WebhookControllerIT {

    private lateinit var app: Javalin
    private lateinit var http: HttpUtil

    @Before
    fun setup() {
        app = AppConfig().setup().start()
        http = HttpUtil(app.port())
    }

    @After
    fun stop() {
        app.stop()
    }

    @Test
    fun `create event`() {
        val issueEvent = loadIssueEvent()
        val response = createEvent()
        assertEquals(response?.status, HttpStatus.CREATED_201)
//        assertNotNull(response?.body?.issue)
//        assertNotNull(response?.body?.repository)
//        assertNotNull(response?.body?.sender)
//        assertEquals(response?.body?.issue, issueEvent.commits)
    }

//    @Test
//    fun `get by event with id`() {
//        createEvent()
//        val response = http.get<IssueEvent>("/api/issues/1/events")
//
//        assertEquals(response.status, HttpStatus.OK_200)
//        assertNotNull(response.body.issue)
////        assertEquals(response.body.articles.size, response.body.articlesCount)
////        response.body.articles.forEach {
////            assertEquals(it.author?.username, author)
////            assertFalse(it.title.isNullOrBlank())
////            assertTrue(it.tagList.isNotEmpty())
////        }
//    }

    private fun createEvent(): HttpResponse<IssueEvent>? {
        val event = loadIssueEvent()
        return http.post<IssueEvent>("/api/events", event)
    }
}