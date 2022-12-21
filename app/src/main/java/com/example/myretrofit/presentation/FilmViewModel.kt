package com.example.myretrofit.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myretrofit.data.repository.FilmRepositoryImpl
import com.example.myretrofit.domain.FilmInfo


class FilmViewModel(private val filmsRepository: FilmRepositoryImpl) : ViewModel() {
    val films: LiveData<List<FilmInfo>>
        get() = filmsRepository.getFilmInfoList()
    fun startListening(count: Int){

    }

}
