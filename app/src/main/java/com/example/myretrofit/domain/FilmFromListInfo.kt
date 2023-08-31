package com.example.myretrofit.domain

data class FilmFromListInfo(
    val id: Int,
    val name: String,
    val releaseYear: String?,
    val genres: List<String>?,
    val imageUrl: String?,
    val ratingKinopoisk: String?,
    val ratingImdb: String?
        )

