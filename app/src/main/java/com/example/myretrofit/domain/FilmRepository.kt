package com.example.myretrofit.domain

import kotlinx.coroutines.flow.Flow

interface FilmRepository {
    suspend fun deleteFilmFromFavorite(filmFromList:FilmFromListInfo)
    suspend fun addFilmToFavorite(filmFromList:FilmFromListInfo)
    fun getFilmInfoList(): Flow<List<FilmFromListInfo>>

    fun getFilmInfo(idFilm: Int): Flow<FilmInfo>

    suspend fun loadFilmsFromServerToBd()

    fun loadStaffFilmFromServer(idFilm: Int): Flow<List<StaffFromFilm>>

}