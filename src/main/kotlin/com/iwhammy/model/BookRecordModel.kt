package com.iwhammy.model

import java.time.LocalDate

data class BookRecordModel(val startReadingDate: LocalDate, val title: String, val authorName: String, val publisher: String)