package com.iwhammy.usecase

import com.iwhammy.domain.BookRecord
import com.iwhammy.domain.BookRecords
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class RecordUsecaseTest {

    lateinit var recordUsecase: RecordUsecase

    @Test
    internal fun testGetRecords() {
        val recordsRepository = mockk<RecordPort>()
        recordUsecase = RecordUsecase(recordsRepository)
        val expected = BookRecords(listOf(BookRecord(LocalDate.of(2020,1,1),
                "Domain-Driven Design",
                "Eric Evans",
                "Addison-Wesley Professional"
        )))
        every { recordsRepository.getRecords() } returns expected

        assertEquals(expected, recordUsecase.getRecords())

        verify { recordsRepository.getRecords() }
    }
}