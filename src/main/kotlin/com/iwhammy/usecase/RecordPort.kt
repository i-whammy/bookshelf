package com.iwhammy.usecase

import com.iwhammy.domain.BookRecords

interface RecordPort {
    fun getRecords(): BookRecords
}