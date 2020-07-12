package com.iwhammy.driver

import io.micronaut.context.annotation.Value
import javax.inject.Singleton

@Singleton
class RakutenSearchConfiguration: SearchConfiguration {

    //     @Value("\${my.engine.cylinders:6}") (1)

    @Value("\${search.rakuten.endpoint}")
    private lateinit var endpoint: String

    @Value("\${search.rakuten.applicationId}")
    private lateinit var applicationId: String

    override fun getBookSearchEndpoint(): String {
        return endpoint
    }

    override fun getDefaultBookSearchParameters(): List<Pair<String, String>> {
        return listOf("applicationId" to applicationId)
    }
}