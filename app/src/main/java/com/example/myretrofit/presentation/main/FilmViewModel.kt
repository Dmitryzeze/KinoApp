package com.example.myretrofit.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myretrofit.data.repository.FilmRepositoryImpl
import com.example.myretrofit.domain.FilmInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.delayFlow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject


class FilmViewModel @Inject constructor(
    private val filmsRepository: FilmRepositoryImpl
    ) : ViewModel() {
    val films: LiveData<List<FilmInfo>>
        get() = filmsRepository.getFilmInfoList().asLiveData()
    fun startListening(count: Int){

    }
}
