package com.iwhammy.controller

import com.iwhammy.domain.BookRecord
import com.iwhammy.domain.BookRecords
import com.iwhammy.model.BookRecordModel
import com.iwhammy.usecase.RecordUsecase
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class RecordControllerTest {

    lateinit var recordController: RecordController

    @Test
    internal fun testGetRecords() {
        val recordUsecase = mockk<RecordUsecase>()
        recordController = RecordController(recordUsecase)
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
}