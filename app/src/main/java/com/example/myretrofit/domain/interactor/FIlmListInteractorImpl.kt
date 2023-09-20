package com.example.myretrofit.domain.interactor

import com.example.myretrofit.domain.FilmFromListInfo
import com.example.myretrofit.domain.FilmRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FIlmListInteractorImpl @Inject constructor(
    private val filmsRepository: FilmRepository
) : FIlmListInteractor {
    override fun getFilmsList(): Flow<List<FilmFromListInfo>> {
        TODO()
    }
}