package com.iwhammy.gateway

import com.iwhammy.domain.BookRecord
import com.iwhammy.domain.BookRecords
import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class RecordGatewayTest {

    lateinit var recordGateway: RecordGateway

    lateinit var recordDriver: IRecordDriver

    @BeforeEach
    fun setup() {
        recordDriver = mockk()
        recordGateway = RecordGateway(recordDriver)
    }

    @Test
    internal fun testGetRecords() {
        every { recordDriver.get() } returns listOf(BookRecordEntity(LocalDate.of(2020,1,1),
                "Domain-Driven Design",
                "Eric Evans",
                "Addison-Wesley Professional"
        ))

        val expected = BookRecords(listOf(BookRecord(LocalDate.of(2020,1,1),
                "Domain-Driven Design",
                "Eric Evans",
                "Addison-Wesley Professional")))
        val actual = recordGateway.getRecords()
        assertEquals(expected, actual)

        verify { recordDriver.get() }
    }

    @Test
    internal fun testAddRecord() {
        val bookRecord = BookRecord(LocalDate.of(2020, 1, 1),
                "Domain-Driven Design",
                "Eric Evans",
                "Addison-Wesley Professional")

        val bookRecordEntity = BookRecordEntity(LocalDate.of(2020, 1, 1),
                        "Domain-Driven Design",
                        "Eric Evans",
                        "Addison-Wesley Professional")

        justRun { recordDriver.addRecord(bookRecordEntity) }

        recordGateway.addRecord(bookRecord)

        verify { recordDriver.addRecord(bookRecordEntity) }
    }
}