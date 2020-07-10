package com.iwhammy.controller

import com.iwhammy.model.BookRecordModel
import com.iwhammy.usecase.RecordUsecase
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/v1/records")
class RecordController(private val usecase: RecordUsecase) {
    @Get("/")
    fun getRecords(): List<BookRecordModel> {
        return usecase.getRecords().records.map { BookRecordModel(it.startReadingDate, it.title, it.authorName, it.publisher) }
    }
}