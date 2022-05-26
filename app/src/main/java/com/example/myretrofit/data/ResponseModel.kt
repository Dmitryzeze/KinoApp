package com.example.myretrofit.data

import com.google.gson.annotations.SerializedName

class ResponseModel (
        @SerializedName("posterUrl") val posterURL: String,
        @SerializedName("kinopoiskId") val id: String,
        @SerializedName("nameRu") val nameRU: String,
        @SerializedName("ratingKinopoisk") val ratingKinopoisk: String,
        @SerializedName("ratingImdb") val ratingImdb: String)
