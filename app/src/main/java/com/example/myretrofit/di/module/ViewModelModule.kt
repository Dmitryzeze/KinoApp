package com.example.myretrofit.di.module

import androidx.lifecycle.ViewModel
import com.example.myretrofit.di.ViewModelKey
import com.example.myretrofit.presentation.film_info.FilmInfoViewModel
import com.example.myretrofit.presentation.main.FilmViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelFactoryModule::class])
interface ViewModelModule {
    @IntoMap
    @Binds
    @ViewModelKey(FilmViewModel::class)
    fun bindsFilmViewModel(viewModel: FilmViewModel): ViewModel
    @IntoMap
    @Binds
    @ViewModelKey(FilmInfoViewModel::class)
    fun bindsFilmInfoViewModel(viewModel: FilmInfoViewModel):ViewModel
}