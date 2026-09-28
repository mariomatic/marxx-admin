package dev.marxx

import io.ktor.server.application.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.http.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable

@Serializable
data class HealthResponse(val status: String, val version: String)

fun main() {
    EngineMain.main(arrayOf())
}

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }
    
    routing {
        get("/api/health") {
            call.respond(HttpStatusCode.OK, HealthResponse(status = "ok", version = "0.1.0"))
        }
        
        get("/api/admin/metrics") {
            call.respond(HttpStatusCode.OK, mapOf(
                "totalItems" to 0,
                "itemsThisWeek" to 0,
                "pendingEdits" to 0
            ))
        }
        
        get("/") {
            call.respondText("Marxx Admin API - v0.1.0", ContentType.Text.Plain)
        }
    }
}
