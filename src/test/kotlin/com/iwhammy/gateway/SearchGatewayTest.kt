package com.iwhammy.gateway

import com.iwhammy.domain.Book
import com.iwhammy.domain.Books
import com.iwhammy.domain.SearchQuery
import com.iwhammy.driver.BookSearchDriver
import com.iwhammy.driver.MockSearchDriver
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SearchGatewayTest{

    lateinit var searchGateway: SearchGateway

    @Test
    internal fun testSearchBooksByTitle() {
        val bookSearchDriver = mockk<IBookSearchDriver>()
        searchGateway = SearchGateway(bookSearchDriver)

        val expected = Books(listOf(Book("Domain-Driver Design",
                "Eric Evans",
                "Addison-Wesley Professional")))

        every { bookSearchDriver.searchBooksByTitle("Domain") } returns listOf(BookEntity("Domain-Driver Design",
                "Eric Evans",
                "Addison-Wesley Professional"))

        val actual = searchGateway.searchBooks(SearchQuery("Domain"))

        assertEquals(expected, actual)
    }
}