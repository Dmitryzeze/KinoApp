package com.example.myretrofit.data.network.model

import com.google.gson.annotations.SerializedName

data class FilmCountryDto (
    @SerializedName("country")
    val country: String?
)