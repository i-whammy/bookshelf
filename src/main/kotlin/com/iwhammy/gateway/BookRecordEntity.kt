package com.iwhammy.gateway

import java.time.LocalDate

data class BookRecordEntity(val startReadingDate: LocalDate, val title: String, val authorName: String, val publisher: String)