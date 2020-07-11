package com.iwhammy.controller

import com.iwhammy.domain.Book
import com.iwhammy.domain.Books
import com.iwhammy.domain.SearchQuery
import com.iwhammy.model.BookModel
import com.iwhammy.usecase.SearchUsecase
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SearchControllerTest {

    lateinit var searchController: SearchController

    @Test
    internal fun testSearchBooks() {
        val searchUsecase = mockk<SearchUsecase>()
        searchController = SearchController(searchUsecase)

        every { searchUsecase.searchBooks(SearchQuery("domain")) } returns Books(listOf(Book("Domain-Driven Design",
                "Eric Evans",
                "Addison-Wesley Professional")))

        val actual = searchController.searchBooks("domain")

        assertEquals(listOf(BookModel("Domain-Driven Design",
                "Eric Evans",
                "Addison-Wesley Professional")), actual)

        verify { searchUsecase.searchBooks(SearchQuery("domain")) }
    }
}