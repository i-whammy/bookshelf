package com.iwhammy.gateway

import com.iwhammy.domain.Book
import com.iwhammy.domain.Books
import com.iwhammy.domain.SearchQuery
import com.iwhammy.usecase.SearchPort
import javax.inject.Singleton

@Singleton
class SearchGateway(private val bookSearchDriver: IBookSearchDriver): SearchPort {
    override fun searchBooks(searchQuery: SearchQuery): Books {
        return bookSearchDriver.searchBooksByTitle(searchQuery.query).map { Book(it.title, it.author, it.publisher) }.let { Books(it) }
    }
}
