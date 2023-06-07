package com.example.myretrofit.domain

import com.example.myretrofit.data.network.model.FilmCountryDto
import com.example.myretrofit.data.network.model.FilmGenreDto
import com.google.gson.annotations.SerializedName
import java.util.Date

data class FilmInfo(
    var kinopoiskId: Int,
    var nameRu: String?,
    var nameEn: String?,
    var nameOriginal: String?,
    var posterUrl: String?,
    var ratingKinopoisk: Double?,
    var ratingImdb: Double?,
    var webUrl: String?,
    var year: Int?,
    var description: String?,
    var type: String?,
    var ratingAgeLimits: String?,
    var countries: List<String>,
    var genres: List<String>

)
