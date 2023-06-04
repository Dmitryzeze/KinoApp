package com.example.myretrofit.data.network.model

import com.google.gson.annotations.SerializedName

data class StaffFilmDto(
    @SerializedName("staffId")
    private val staffId : Int,
    @SerializedName("nameRu")
    private val nameRu : String,
    @SerializedName("nameEn")
    private val nameEn :String,
    @SerializedName("description")
    private val description : String,
    @SerializedName("posterUrl")
    private val posterUrl : String,
    @SerializedName("professionKey")
    private val professionKey : String
)