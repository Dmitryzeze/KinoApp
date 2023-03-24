package com.example.myretrofit.presentation.di.module;

import com.example.myretrofit.data.repository.FilmRepositoryImpl;
import com.example.myretrofit.domain.FilmRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
class  RepositoryModule {
    @Binds
    @Singleton
    fun bindsFilmRepository (repository : FilmRepositoryImpl) : FilmRepository

}
