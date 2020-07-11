package com.iwhammy.controller

import com.iwhammy.domain.SearchQuery
import com.iwhammy.model.BookModel
import com.iwhammy.usecase.SearchUsecase
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue

@Controller("/v1/search")
class SearchController(private val searchUsecase: SearchUsecase) {

    @Get("/")
    fun searchBooks(@QueryValue query: String): List<BookModel> {
        return searchUsecase.searchBooks(SearchQuery(query)).books.map { BookModel(it.title, it.author, it.publisher) }
    }
}