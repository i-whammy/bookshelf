package com.iwhammy.usecase

import com.iwhammy.domain.Books
import com.iwhammy.domain.SearchQuery

interface SearchPort {
    fun searchBooks(searchQuery: SearchQuery): Books
}