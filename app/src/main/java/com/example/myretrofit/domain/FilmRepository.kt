package com.example.myretrofit.domain

import kotlinx.coroutines.flow.Flow

interface FilmRepository {
    fun getFilmInfoList(): Flow<List<FilmFromListInfo>>

    suspend fun getFilmInfo(idFilm: Int): FilmInfo

    suspend fun loadFilmsFromServerToBd()

    fun loadStaffFilmFromServer() : Flow<FilmFromListInfo>

}