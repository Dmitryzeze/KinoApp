package com.example.myretrofit.data.network.model

import com.google.gson.annotations.SerializedName

data class FilmGenreDto(
    @SerializedName("genre")
    val genre: String
)
