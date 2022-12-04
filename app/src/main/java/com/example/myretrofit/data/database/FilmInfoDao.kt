package com.example.myretrofit.data.database

import androidx.room.PrimaryKey

class FilmInfoDao {
    @PrimaryKey
    val id  : Int,
    val name : String?,
    val releaseYear : Int?,
    val genre : String?,
    val imageUrl : String?,
    val ratingKinopoisk: String?,
    val ratingImdb: String?
}