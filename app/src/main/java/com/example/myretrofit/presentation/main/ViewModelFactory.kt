package com.example.myretrofit.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myretrofit.data.repository.FilmRepositoryImpl
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val filmsRepository: FilmRepositoryImpl) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        modelClass.checkedViewModel?.let { return it.get() as T }
        throw IllegalArgumentException("Unknown model class $modelClass")
    }

    private val <T : ViewModel> Class<T>.checkedViewModel: Provider<ViewModel>?
        get() = viewModelMap[this] ?: checkViewModelAssignable()

    private fun <T> Class<T>.checkViewModelAssignable(): Provider<ViewModel>? {
        viewModelMap.forEach {
            if (isAssignableFrom(it.key)) return it.value
        }
        return null
    }
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FilmViewModel(filmsRepository) as T
    }
}