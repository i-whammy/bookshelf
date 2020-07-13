package com.iwhammy.controller

import com.iwhammy.domain.BookRecord
import com.iwhammy.domain.BookRecords
import com.iwhammy.model.BookRecordModel
import com.iwhammy.usecase.RecordUsecase
import io.mockk.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class RecordControllerTest {

    lateinit var recordController: RecordController

    lateinit var recordUsecase: RecordUsecase

    @BeforeEach
    fun setup() {
        recordUsecase = mockk()
        recordController = RecordController(recordUsecase)
    }

    @Test
    internal fun testGetRecords() {
        val bookRecords = BookRecords(listOf(BookRecord(LocalDate.of(2020, 1, 1),
                "Domain-Driven Design",
                "Eric Evans",
                "Addison-Wesley Professional"
        )))
        val expected = listOf(
                BookRecordModel(LocalDate.of(2020, 1, 1),
                        "Domain-Driven Design",
                        "Eric Evans",
                        "Addison-Wesley Professional"
                ))

        every { recordUsecase.getRecords() } returns bookRecords

        assertEquals(expected, recordController.getRecords())

        verify { recordUsecase.getRecords() }
    }

    @Test
    internal fun testAddRecord() {

        val bookRecordModel = BookRecordModel(LocalDate.of(2020, 1, 1),
                "Domain-Driven Design",
                "Eric Evans",
                "Addison-Wesley Professional"
        )
        val bookRecord = BookRecord(LocalDate.of(2020, 1, 1),
                "Domain-Driven Design",
                "Eric Evans",
                "Addison-Wesley Professional"
        )
        val expected = BookRecordModel(LocalDate.of(2020, 1, 1),
                "Domain-Driven Design",
                "Eric Evans",
                "Addison-Wesley Professional"
        )

        justRun { recordUsecase.addRecord(bookRecord) }

        recordController.addRecord(bookRecordModel)

        verify { recordUsecase.addRecord(bookRecord) }
    }
}