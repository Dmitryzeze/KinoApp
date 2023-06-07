package com.example.myretrofit.presentation.film_info

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.myretrofit.domain.FilmFromListInfo
import com.example.myretrofit.domain.FilmRepository
import javax.inject.Inject

class FilmInfoViewModel @Inject constructor(
    private val filmsRepository: FilmRepository
) : ViewModel() {
    fun getFilmInfo(id: Int): LiveData<FilmFromListInfo> = filmsRepository.getFilmInfo(id).asLiveData()

}
