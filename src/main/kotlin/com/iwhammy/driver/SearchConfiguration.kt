package com.iwhammy.driver

interface SearchConfiguration {
    fun getBookSearchEndpoint(): String
    fun getDefaultBookSearchParameters(): List<Pair<String, String>>
}
