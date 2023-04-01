package com.example.myretrofit.data.database

interface BaseAppDatabase<T> {
    fun dao(): T
}