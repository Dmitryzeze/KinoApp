package com.example.myretrofit.presentation.di.module

import com.example.myretrofit.data.repository.FilmRepositoryImpl
import com.example.myretrofit.domain.FilmRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindsFilmRepository (repository : FilmRepositoryImpl) : FilmRepository

}