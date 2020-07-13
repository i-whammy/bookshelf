package com.iwhammy.usecase

import com.iwhammy.domain.BookRecord
import com.iwhammy.domain.BookRecords

interface RecordPort {
    fun getRecords(): BookRecords
    fun addRecord(bookRecord: BookRecord)
}