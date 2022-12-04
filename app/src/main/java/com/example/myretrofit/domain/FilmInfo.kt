package com.example.myretrofit.domain

data class FilmInfo (
    val id  : Int,
    val name : String?,
    val releaseYear : Int?,
    val genre : String?,
    val imageUrl : String?,
    val ratingKinopoisk: String?,
    val ratingImdb: String?
        )

