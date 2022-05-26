package com.example.myretrofit.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyViewModelFactory(private val filmsRepository: FilmRepository): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel> create (modelClass: Class<T>): T{
        return FilmViewModel(filmsRepository) as T
    }
}