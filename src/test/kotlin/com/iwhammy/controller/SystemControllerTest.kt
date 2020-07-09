package com.iwhammy.controller

import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import javax.inject.Inject

@MicronautTest
class SystemControllerTest {
    @Inject
    lateinit var server: EmbeddedServer

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @org.junit.jupiter.api.Test
    internal fun testPingPong() {
        val response = client.toBlocking().retrieve("/v1/systems/ping")
        assertEquals("pong", response)
    }
}