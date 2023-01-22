package com.example.myretrofit.domain

import com.example.myretrofit.data.network.model.FilmGenreDto

data class FilmInfo(
    val id: Int,
    val name: String,
    val releaseYear: String?,
    val genres: List<String>?,
    val imageUrl: String?,
    val ratingKinopoisk: String?,
    val ratingImdb: String?
        )

