package com.example.myretrofit.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.myretrofit.domain.FilmFromListInfo
import com.example.myretrofit.domain.FilmRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject


class FilmViewModel @Inject constructor(
    private val filmsRepository: FilmRepository
) : ViewModel() {
    val films: LiveData<List<FilmFromListInfo>>
        get() = filmsRepository.getFilmInfoList().asLiveData()

    fun addFilmToFavorite(film: FilmFromListInfo) =
        viewModelScope.launch { filmsRepository.addFilmToFavorite(film) }

    fun deleteFilmFromFavorite(film: FilmFromListInfo) =
        viewModelScope.launch { filmsRepository.deleteFilmFromFavorite(film) }

}
