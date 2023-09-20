package com.example.myretrofit.domain.interactor

import com.example.myretrofit.domain.FilmFromListInfo
import kotlinx.coroutines.flow.Flow

interface FIlmListInteractor {
    fun getFilmsList(): Flow<List<FilmFromListInfo>>
}