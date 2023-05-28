package com.example.myretrofit.domain

import kotlinx.coroutines.flow.Flow

interface FilmRepository {
    fun getFilmInfoList(): Flow<List<FilmInfo>>

    fun getFilmInfo(idFilm: Int): Flow<FilmInfo>

    suspend fun loadFilmsFromServer()

}