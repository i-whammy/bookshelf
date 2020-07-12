package com.iwhammy.driver

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.result.Result
import com.iwhammy.gateway.BookEntity
import com.iwhammy.gateway.IBookSearchDriver
import io.micronaut.context.annotation.Infrastructure
import org.json.JSONException

@Infrastructure
class BookSearchDriver(private val searchConfiguration: SearchConfiguration): IBookSearchDriver {

    override fun searchBooksByTitle(title: String): List<BookEntity> {
        val searchEndpoint = searchConfiguration.getBookSearchEndpoint()
        val defaultSearchParameter = searchConfiguration.getDefaultBookSearchParameters()
        val bookEntities = mutableListOf<BookEntity>()

        searchEndpoint.httpGet(listOf("title" to title) + defaultSearchParameter).responseJson { _, _, result ->
            when (result) {
                is Result.Failure -> {
                    // TODO handle failure
                    println(result.error)
                }
                is Result.Success -> {
                    try {
                        val items = result.get().obj().getJSONArray("Items")
                        for (i in 0 until items.length()) {
                            val item = items.getJSONObject(i).getJSONObject("Item")
                            bookEntities.add(BookEntity(item.getString("title"), item.getString("author"), item.getString("publisherName")))
                        }
                    } catch (e: JSONException) {
                        println(e)
                    }
                }
            }
        }.join()
        return bookEntities
    }
}
