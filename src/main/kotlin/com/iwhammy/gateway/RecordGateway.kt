package com.iwhammy.gateway

import com.iwhammy.domain.BookRecord
import com.iwhammy.domain.BookRecords
import com.iwhammy.usecase.RecordPort
import javax.inject.Singleton

@Singleton
class RecordGateway(private val recordDriver: IRecordDriver): RecordPort {
    override fun getRecords(): BookRecords {
        return recordDriver.get().map { BookRecord(it.startReadingDate, it.title, it.authorName, it.publisher) }.let { BookRecords(it) }
    }

    override fun addRecord(bookRecord: BookRecord) {
        val bookRecordEntity = BookRecordEntity(bookRecord.startReadingDate, bookRecord.title, bookRecord.authorName, bookRecord.publisher)
        recordDriver.addRecord(bookRecordEntity)
    }
}