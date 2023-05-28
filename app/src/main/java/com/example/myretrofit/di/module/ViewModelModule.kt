package com.example.myretrofit.di.module

import com.example.myretrofit.presentation.film_info.FilmInfoViewModel
import com.example.myretrofit.presentation.main.FilmViewModel
import dagger.Binds
import dagger.Module

@Module(includes = [ViewModelFactoryModule::class])
interface ViewModelModule {
    @Binds
    fun bindsFilmViewModel(viewModel: FilmViewModel): FilmViewModel
    @Binds
    fun bindsFilmInfoViewModel(viewModel: FilmInfoViewModel):FilmInfoViewModel
}