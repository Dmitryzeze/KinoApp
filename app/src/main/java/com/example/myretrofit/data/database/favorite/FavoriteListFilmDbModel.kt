package com.example.myretrofit.data.database.favorite

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "favorite_film_list")
data class FavoriteListFilmDbModel (
    @PrimaryKey
    val id: Int,
    val name: String,
    val releaseYear: String?,
    val genres: List<String>?,
    val imageUrl: String?,
    val ratingKinopoisk: String?,
    val ratingImdb: String?,
)