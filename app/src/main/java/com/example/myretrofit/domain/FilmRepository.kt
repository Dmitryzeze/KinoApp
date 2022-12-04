package com.example.myretrofit.domain

import androidx.lifecycle.LiveData

interface FilmRepository {
    fun getFilmInfoList(): LiveData<List<FilmInfo>>

    fun getFilmInfo(idFilm: Int): LiveData<FilmInfo>
}