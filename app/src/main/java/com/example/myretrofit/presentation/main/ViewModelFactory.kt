package com.example.myretrofit.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myretrofit.data.repository.FilmRepositoryImpl
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val filmsRepository: FilmRepositoryImpl): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel> create (modelClass: Class<T>): T{
        return FilmViewModel(filmsRepository) as T
    }
}