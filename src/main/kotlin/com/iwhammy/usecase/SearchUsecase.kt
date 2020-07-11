package com.iwhammy.usecase

import com.iwhammy.domain.Books
import com.iwhammy.domain.SearchQuery
import javax.inject.Singleton

@Singleton
class SearchUsecase(private val searchPort: SearchPort) {
    fun searchBooks(searchQuery: SearchQuery): Books {
        return searchPort.searchBooks(searchQuery)
    }
}
