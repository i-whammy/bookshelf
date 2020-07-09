package com.iwhammy.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/v1/systems")
class SystemController {

    @Get("/ping")
    fun ping(): String {
        return "pong"
    }
}