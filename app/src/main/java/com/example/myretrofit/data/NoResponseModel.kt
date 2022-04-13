package com.example.myretrofit.data

import com.google.gson.annotations.SerializedName

class NoResponseModel (
    @SerializedName("timestamp") val id: String,
    @SerializedName("status") val nameRU: Int,
    @SerializedName("error") val ratingKinopoisk: String,
    @SerializedName("path") val ratingImdb: String){
        fun text1(): String {
            return "id:$id\nname:$nameRU\nrating KP:$ratingKinopoisk\nrating Imbd:$ratingImdb"
        }
    }
