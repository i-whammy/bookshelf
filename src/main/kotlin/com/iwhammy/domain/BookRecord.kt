package com.iwhammy.domain

import java.time.LocalDate

data class BookRecord(val startReadingDate: LocalDate, val title: String, val authorName: String, val publisher: String) {
}

data class BookRecords(val records: List<BookRecord>)