package com.example.myretrofit.data.network.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "full_film_list")
data class FilmListInfoDto(
    @SerializedName("filmId")
    val filmId: Int?,
    @SerializedName("nameRu")
    val nameRu: String?,
    @SerializedName("nameEn")
    val nameEn: String?,
    @SerializedName("year")
    val year: String?,
    @SerializedName("filmLength")
    val filmLength: String?,
    @SerializedName("countries")
    val countries: List<FilmCountryDto>?,
    @SerializedName("genres")
    val genres: List<FilmGenreDto>?,
    @SerializedName("rating")
    val rating: String?,
    @SerializedName("ratingVoteCount")
    val ratingVoteCount: Int?,
    @SerializedName("posterUrl")
    val posterUrl: String?,
    @SerializedName("posterUrlPreview")
    val posterUrlPreview: String? = null
)