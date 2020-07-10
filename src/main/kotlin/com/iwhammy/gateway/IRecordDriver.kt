package com.iwhammy.gateway

interface IRecordDriver {
    fun get(): List<BookRecordEntity>
}