package com.iwhammy.usecase

import com.iwhammy.domain.BookRecord
import com.iwhammy.domain.BookRecords
import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class RecordUsecaseTest {

    lateinit var recordUsecase: RecordUsecase

    lateinit var recordPort: RecordPort

    @BeforeEach
    fun setup() {
        recordPort = mockk()
        recordUsecase = RecordUsecase(recordPort)
    }

    @Test
    internal fun testGetRecords() {
        val expected = BookRecords(listOf(BookRecord(LocalDate.of(2020,1,1),
                "Domain-Driven Design",
                "Eric Evans",
                "Addison-Wesley Professional"
        )))
        every { recordPort.getRecords() } returns expected

        assertEquals(expected, recordUsecase.getRecords())

        verify { recordPort.getRecords() }
    }

    @Test
    internal fun testAddRecord() {
        val bookRecord = BookRecord(LocalDate.of(2020,1,1),
                "Domain-Driven Design",
                "Eric Evans",
                "Addison-Wesley Professional"
        )

        justRun { recordPort.addRecord(bookRecord) }

        recordUsecase.addRecord(bookRecord)

        verify { recordPort.addRecord(bookRecord) }
    }
}