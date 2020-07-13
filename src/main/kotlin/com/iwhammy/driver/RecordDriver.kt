package com.iwhammy.driver

import com.iwhammy.gateway.BookRecordEntity
import com.iwhammy.gateway.IRecordDriver
import io.micronaut.context.annotation.Infrastructure
import java.time.LocalDate

@Infrastructure
class RecordDriver: IRecordDriver {

    private val bookRecords = mutableListOf(
            BookRecordEntity(LocalDate.of(2020, 1, 1),
                    "Domain-Driven Design",
                    "Eric Evans",
                    "Addison-Wesley Professional"
            )
    )

    override fun get(): List<BookRecordEntity> {
        return bookRecords
    }

    override fun addRecord(bookRecordEntity: BookRecordEntity) {
        bookRecords.add(bookRecordEntity)
    }
}