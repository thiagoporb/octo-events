package com.example.octoevents.config

import com.example.octoevents.config.ModulesConfig.allModules
import com.example.octoevents.web.Router
import com.example.octoevents.web.erros.ErrorExceptionMapping
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.javalin.Javalin
import io.javalin.plugin.json.JavalinJackson
import io.javalin.plugin.openapi.OpenApiPlugin
import org.eclipse.jetty.server.Server
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.inject
import org.koin.core.logger.Level
import java.text.SimpleDateFormat

class AppConfig : KoinComponent {

    private val router by inject<Router>()

    fun setup(): Javalin {

        startKoin {
            printLogger(Level.ERROR)
            fileProperties()
            modules(allModules)
        }

        this.configureMapper()

        val app = Javalin.create { config ->
            config
                .apply {
                    registerPlugin(OpenApiPlugin(getOpenApiOptions2()))
                    enableWebjars()
                    enableCorsForAllOrigins()
                    contextPath = getKoin().getProperty("context")!!
                    //addStaticFiles("/swagger")
                    //addSinglePageRoot("", "/swagger/swagger-ui.html")
                    server {
                        getKoin().getProperty("server_port")?.toInt()?.let { Server(it) }
                    }
                }
        }.events {
            it.serverStopping {
                stopKoin()
            }
        }
        router.register(app)
        ErrorExceptionMapping.register(app)
        return app
    }

    private fun configureMapper() {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        JavalinJackson.configure(
            jacksonObjectMapper()
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .setDateFormat(dateFormat)
                .configure(SerializationFeature.WRITE_DATES_WITH_ZONE_ID, true)
        )
    }


}