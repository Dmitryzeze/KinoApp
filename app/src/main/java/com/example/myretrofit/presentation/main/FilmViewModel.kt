package com.example.myretrofit.presentation.main

import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myretrofit.data.repository.FilmRepositoryImpl
import com.example.myretrofit.domain.FilmInfo
import com.example.myretrofit.domain.FilmRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.delayFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
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
