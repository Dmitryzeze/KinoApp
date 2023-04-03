package com.example.myretrofit.domain

import androidx.lifecycle.LiveData

interface FilmRepository {
    fun getFilmInfoList(): LiveData<List<FilmInfo>>

    suspend fun getFilmInfo(idFilm: Int): FilmInfo

    suspend fun loadFilmsFromServer(page: Int)
}