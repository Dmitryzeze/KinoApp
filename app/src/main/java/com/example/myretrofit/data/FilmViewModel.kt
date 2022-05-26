package com.example.myretrofit.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myretrofit.data.model.Film
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch


class FilmViewModel(private val filmsRepository: FilmRepository) : ViewModel() {
    val films: LiveData<List<Film>>
        get() = filmsRepository.films
    fun startListening(count: Int){
        viewModelScope.launch(Dispatchers.IO){
            filmsRepository.startListeningFilms(count)
        }
    }

}
