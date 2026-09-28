package dev.marxx

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.server.testing.*
import kotlin.test.*

class ApplicationTest {
    @Test
    fun testHealthEndpoint() = testApplication {
        val response = client.get("/api/health")
        assertEquals(200, response.status.value)
        assertTrue(response.bodyAsText().contains("ok"))
    }
    
    @Test
    fun testMetricsEndpoint() = testApplication {
        val response = client.get("/api/admin/metrics")
        assertEquals(200, response.status.value)
        assertTrue(response.bodyAsText().contains("totalItems"))
    }
}
