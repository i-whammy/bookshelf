package com.iwhammy.controller

import com.iwhammy.domain.BookRecord
import com.iwhammy.model.BookRecordModel
import com.iwhammy.usecase.RecordUsecase
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("/v1/records")
class RecordController(private val usecase: RecordUsecase) {
    @Get("/")
    fun getRecords(): List<BookRecordModel> {
        return usecase.getRecords().records.map { BookRecordModel(it.startReadingDate, it.title, it.authorName, it.publisher) }
    }

    @Post("/")
    fun addRecord(@Body bookRecordModel: BookRecordModel) {
        val bookRecord = BookRecord(bookRecordModel.startReadingDate, bookRecordModel.title, bookRecordModel.authorName, bookRecordModel.publisher)
        usecase.addRecord(bookRecord)
    }
}