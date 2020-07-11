package com.iwhammy.gateway

interface IBookSearchDriver {
    fun searchBooksByTitle(title: String): List<BookEntity>
}