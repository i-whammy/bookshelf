package com.iwhammy.usecase

import com.iwhammy.domain.BookRecords
import javax.inject.Singleton

@Singleton
class RecordUsecase(private val recordPort: RecordPort) {
    fun getRecords(): BookRecords {
        return recordPort.getRecords()
    }
}