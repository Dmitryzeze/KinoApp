package com.example.myretrofit.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.myretrofit.domain.FilmInfo
import com.example.myretrofit.domain.FilmRepository
import kotlinx.coroutines.launch
import javax.inject.Inject


class FilmViewModel @Inject constructor(
    private val filmsRepository: FilmRepository
) : ViewModel() {

    val films: LiveData<List<FilmInfo>>
        get() = filmsRepository.getFilmInfoList().asLiveData()

    init {
        viewModelScope.launch {
            filmsRepository.loadFilmsFromServer()
        }
    }

    fun startListening(count: Int) {

    }
}
