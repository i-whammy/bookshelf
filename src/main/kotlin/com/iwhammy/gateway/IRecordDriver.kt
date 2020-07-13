package com.iwhammy.gateway

interface IRecordDriver {
    fun get(): List<BookRecordEntity>
    fun addRecord(bookRecordEntity: BookRecordEntity)
}