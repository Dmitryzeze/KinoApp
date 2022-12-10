package com.example.myretrofit.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myretrofit.data.database.FilmRepositoryImpl
import com.example.myretrofit.domain.FilmInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FilmViewModel(private val filmsRepository: FilmRepositoryImpl) : ViewModel() {
    val films: LiveData<List<FilmInfo>>
        get() = filmsRepository.getFilmInfoList()
    fun startListening(count: Int){

    }

}
