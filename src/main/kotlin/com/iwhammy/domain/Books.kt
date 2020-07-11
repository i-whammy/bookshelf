package com.iwhammy.domain

data class Books(val books: List<Book>)

data class Book(val title: String, val author: String, val publisher: String)