package com.example.octoevents.config

import com.example.octoevents.domain.issue.IssueEvent
import io.javalin.plugin.openapi.InitialConfigurationCreator
import io.javalin.plugin.openapi.OpenApiOptions
import io.javalin.plugin.openapi.annotations.HttpMethod
import io.javalin.plugin.openapi.dsl.document
import io.javalin.plugin.openapi.jackson.JacksonModelConverterFactory
import io.javalin.plugin.openapi.jackson.JacksonToJsonMapper
import io.javalin.plugin.openapi.ui.ReDocOptions
import io.javalin.plugin.openapi.ui.SwaggerOptions

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info

val initialConfigurationCreator = InitialConfigurationCreator {
    OpenAPI()
        .info(Info().version("1.0").description("Octo Events"))
}

fun getOpenApiOptions2(): OpenApiOptions {
    val applicationInfo: Info = Info()
        .version("1.0")
        .description("Octo Events")
    return OpenApiOptions(initialConfigurationCreator)
        .path("/swagger-docs") // Activate the open api endpoint
        //.roles(roles(MyRole())) // Require specific roles for the open api endpoint
        //.defaultDocumentation(DefaultDocumentation { doc: OpenApiDocumentation -> doc.json("500", MyError::class.java) }) // Lambda that will be applied to every documentation
        .activateAnnotationScanningFor("com.example.octoevents") // Activate annotation scanning (Required for annotation api with static java methods)
        .toJsonMapper(JacksonToJsonMapper()/*.INSTANCE*/) // Custom json mapper
        .modelConverterFactory(JacksonModelConverterFactory()/*.INSTANCE*/) // Custom OpenAPI model converter
        .swagger(SwaggerOptions("/swagger").title("Octo Events Documentation")) // Activate the swagger ui
        .reDoc(ReDocOptions("/redoc").title("Octo Events Documentation")) // Active the ReDoc UI
        .setDocumentation("/api/events", HttpMethod.POST, document().operation {
            it.description("Cria o evento do tipo issues")
            it.operationId("myOperationId")
            it.summary("Salva o evento do tipo issues no banco")
            it.deprecated(false)
            it.addTagsItem("IssueEvent")
        }.body<IssueEvent>()) // Override or set some documentation manually
        .ignorePath("/user*", HttpMethod.GET)
}

fun getOpenApiOptions(): OpenApiOptions {
    val applicationInfo: Info = Info()
        .version("1.0")
        .description("Octo Events")
    return OpenApiOptions(applicationInfo).path("/swagger-docs")
}