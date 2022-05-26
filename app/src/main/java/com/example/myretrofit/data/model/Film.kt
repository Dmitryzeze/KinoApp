package com.example.myretrofit.data.model

data class Film (
    val kinopoiskId : Int?,
    val posterUrl: String,
    val nameRu: String?,
    val ratingKinopoisk : Double?,
    val ratingImdb : Double?
)