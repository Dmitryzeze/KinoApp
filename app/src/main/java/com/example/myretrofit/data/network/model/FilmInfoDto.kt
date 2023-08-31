package com.example.myretrofit.data.network.model

import com.google.gson.annotations.SerializedName
import java.util.Date


data class FilmInfoDto(
    @SerializedName("kinopoiskId")
    val kinopoiskId: Int,
    @SerializedName("imdbId")
    val imdbId: String? = null,
    @SerializedName("nameRu")
    val nameRu: String? = null,
    @SerializedName("nameEn")
    val nameEn: String? = null,
    @SerializedName("nameOriginal")
    val nameOriginal: String? = null,
    @SerializedName("posterUrl")
    val posterUrl: String,
    @SerializedName("posterUrlPreview")
    val posterUrlPreview: String,
    @SerializedName("coverUrl")
    val coverUrl: String? = null,
    @SerializedName("logoUrl")
    val logoUrl: String? = null,
    @SerializedName("reviewsCount")
    val reviewsCount: Int,
    @SerializedName("ratingGoodReview")
    val ratingGoodReview: Double? = null,
    @SerializedName("ratingGoodReviewVoteCount")
    val ratingGoodReviewVoteCount: Int? = null,
    @SerializedName("ratingKinopoisk")
    val ratingKinopoisk: Double? = null,
    @SerializedName("ratingKinopoiskVoteCount")
    val ratingKinopoiskVoteCount: Int? = null,
    @SerializedName("ratingImdb")
    val ratingImdb: Double? = null,
    @SerializedName("ratingImdbVoteCount")
    val ratingImdbVoteCount: Int? = null,
    @SerializedName("ratingFilmCritics")
    val ratingFilmCritics: Double? = null,
    @SerializedName("ratingFilmCriticsVoteCount")
    val ratingFilmCriticsVoteCount: Int? = null,
    @SerializedName("ratingAwait")
    val ratingAwait: Any? = null,
    @SerializedName("ratingAwaitCount")
    val ratingAwaitCount: Int? = null,
    @SerializedName("ratingRfCritics")
    val ratingRfCritics: Double? = null,
    @SerializedName("ratingRfCriticsVoteCount")
    val ratingRfCriticsVoteCount: Int? = null,
    @SerializedName("webUrl")
    val webUrl: String? = null,
    @SerializedName("year")
    val year: Int? = null,
    @SerializedName("filmLength")
    val filmLength: Int? = null,
    @SerializedName("slogan")
    val slogan: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("shortDescription")
    val shortDescription: String? = null,
    @SerializedName("editorAnnotation")
    val editorAnnotation: Any? = null,
    @SerializedName("isTicketsAvailable")
    val isTicketsAvailable: Boolean? = null,
    @SerializedName("type")
    val type: String,
    @SerializedName("ratingMpaa")
    val ratingMpaa: String? = null,
    @SerializedName("ratingAgeLimits")
    val ratingAgeLimits: String? = null,
    @SerializedName("countries")
    val countries: List<FilmCountryDto>,
    @SerializedName("genres")
    val genres: List<FilmGenreDto>,
    @SerializedName("startYear")
    val startYear: Int? = null,
    @SerializedName("endYear")
    val endYear: Int? = null,
    @SerializedName("serial")
    val serial: Boolean? = null,
    @SerializedName("shortFilm")
    val shortFilm: Boolean? = null,
    @SerializedName("completed")
    val completed: Boolean? = null,
    @SerializedName("hasImax")
    val hasImax: Boolean? = null,
    @SerializedName("has3D")
    val has3D: Boolean? = null,
    @SerializedName("lastSync")
    val lastSync: String? = null
)
