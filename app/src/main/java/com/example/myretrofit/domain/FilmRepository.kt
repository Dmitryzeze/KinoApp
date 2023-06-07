package com.example.myretrofit.domain

import kotlinx.coroutines.flow.Flow

interface FilmRepository {
    fun getFilmInfoList(): Flow<List<FilmFromListInfo>>

    fun getFilmInfo(idFilm: Int): Flow<FilmFromListInfo>

    suspend fun loadFilmsFromServerToBd()

    fun loadStaffFilmFromServer() : Flow<FilmFromListInfo>

}