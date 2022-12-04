package com.example.myretrofit.data.network.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "full_film_list")
data class FilmInfoDto(
    @SerializedName("filmId")
    val filmId: Int? = null,
    @SerializedName("nameRu")
    val nameRu: String? = null,
    @SerializedName("nameEn")
    val nameEn: String? = null,
    @SerializedName("year")
    val year: String? = null,
    @SerializedName("filmLength")
    val filmLength: String? = null,
    @SerializedName("countries")
    val countries: List<FilmCountryDto>? = null,
    @SerializedName("genres")
    val genres: List<FilmGenreDto>? = null,
    @SerializedName("rating")
    val rating: String? = null,
    @SerializedName("ratingVoteCount")
    val ratingVoteCount: Int? = null,
    @SerializedName("posterUrl")
    val posterUrl: String? = null,
    @SerializedName("posterUrlPreview")
    val posterUrlPreview: String? = null
)