package com.example.myretrofit.domain

import kotlinx.coroutines.flow.Flow

interface FilmRepository {
    fun getFilmInfoList(): Flow<List<FilmFromListInfo>>

    fun getFilmInfo(idFilm: Int): Flow<FilmInfo>

    suspend fun loadFilmsFromServerToBd()

    fun loadStaffFilmFromServer(idFilm: Int): Flow<List<StaffFromFilm>>

}