package com.example.myretrofit.data.network.model

import com.google.gson.annotations.SerializedName

data class FilmContainerDto (
    @SerializedName("films")
    val films: List<FilmListInfoDto>?
        )
