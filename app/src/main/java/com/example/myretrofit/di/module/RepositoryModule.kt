package com.example.myretrofit.di.module

import com.example.myretrofit.data.repository.FilmRepoMockImpl
import com.example.myretrofit.data.repository.FilmRepositoryImpl
import com.example.myretrofit.domain.FilmRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindsFilmRepository (repository : FilmRepoMockImpl) : FilmRepository

}