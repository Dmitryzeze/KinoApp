package com.example.myretrofit.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.myretrofit.domain.FilmFromListInfo
import com.example.myretrofit.domain.FilmRepository
import kotlinx.coroutines.launch
import javax.inject.Inject


class  FilmViewModel @Inject constructor(
    private val filmsRepository: FilmRepository
) : ViewModel() {

    val films: LiveData<List<FilmFromListInfo>>
        get() = filmsRepository.getFilmInfoList().asLiveData()
//    fun getFilmInfoFromDB(id : Int) = filmsRepository.

//    init {
//        viewModelScope.launch {
//            filmsRepository.loadFilmsFromServerToBd()
//        }
//    }
}
