package com.iwhammy.driver

import com.iwhammy.gateway.BookEntity
import com.iwhammy.gateway.IBookSearchDriver

class MockSearchDriver: IBookSearchDriver {
    override fun searchBooksByTitle(title: String): List<BookEntity> {
        return emptyList()
    }
}