package com.example.myretrofit.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myretrofit.data.database.FilmRepositoryImpl

class MyViewModelFactory(private val filmsRepository: FilmRepositoryImpl): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel> create (modelClass: Class<T>): T{
        return FilmViewModel(filmsRepository) as T
    }
}