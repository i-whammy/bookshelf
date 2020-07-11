package com.iwhammy.usecase

import com.iwhammy.domain.Book
import com.iwhammy.domain.Books
import com.iwhammy.domain.SearchQuery
import com.iwhammy.gateway.SearchGateway
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SearchUsecaseTest {

    lateinit var searchUsecase: SearchUsecase

    @Test
    internal fun testSearchBooks() {
        val gateway = mockk<SearchPort>()
        searchUsecase = SearchUsecase(gateway)
        val query = SearchQuery("Domain")
        val expected = Books(listOf(Book("Domain-Driven Design",
                "Eric Evans",
                "Addison-Wesley Professional")))

        every { gateway.searchBooks(query) } returns expected

        val actual = searchUsecase.searchBooks(query)

        assertEquals(expected, actual)

        verify { gateway.searchBooks(query) }
    }
}