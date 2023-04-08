package com.example.myretrofit.domain

import kotlinx.coroutines.flow.Flow

interface FilmRepository {
    fun getFilmInfoList(): Flow<List<FilmInfo>>

    suspend fun getFilmInfo(idFilm: Int): FilmInfo

    suspend fun loadFilmsFromServer()

}