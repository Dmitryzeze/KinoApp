package com.example.myretrofit.data.network.model

import com.google.gson.annotations.SerializedName

class model {
    @SerializedName("kinopoiskId")
    private val kinopoiskId: Int? = null

    @SerializedName("imdbId")
    private val imdbId: String? = null

    @SerializedName("nameRu")
    private val nameRu: String? = null

    @SerializedName("nameEn")
    private val nameEn: Any? = null

    @SerializedName("nameOriginal")
    private val nameOriginal: String? = null

    @SerializedName("posterUrl")
    private val posterUrl: String? = null

    @SerializedName("posterUrlPreview")
    private val posterUrlPreview: String? = null

    @SerializedName("coverUrl")
    private val coverUrl: String? = null

    @SerializedName("logoUrl")
    private val logoUrl: String? = null

    @SerializedName("reviewsCount")
    private val reviewsCount: Int? = null

    @SerializedName("ratingGoodReview")
    private val ratingGoodReview: Double? = null

    @SerializedName("ratingGoodReviewVoteCount")
    private val ratingGoodReviewVoteCount: Int? = null

    @SerializedName("ratingKinopoisk")
    private val ratingKinopoisk: Double? = null

    @SerializedName("ratingKinopoiskVoteCount")
    private val ratingKinopoiskVoteCount: Int? = null

    @SerializedName("ratingImdb")
    private val ratingImdb: Double? = null

    @SerializedName("ratingImdbVoteCount")
    private val ratingImdbVoteCount: Int? = null
}