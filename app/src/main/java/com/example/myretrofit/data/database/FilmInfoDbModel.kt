package com.example.myretrofit.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myretrofit.data.network.model.FilmGenreDto

@Entity(tableName = "full_film_list")
data class FilmInfoDbModel(
    @PrimaryKey(autoGenerate = true)
    val idBD: Int =0,
    val id: Int,
    val name: String,
    val releaseYear: String?,
    val genres: List<String>?,
    val imageUrl: String?,
    val ratingKinopoisk: String?,
    val ratingImdb: String?,
)