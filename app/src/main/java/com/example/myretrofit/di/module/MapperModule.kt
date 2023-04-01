package com.example.myretrofit.di.module

import com.example.myretrofit.data.mapper.FilmMapper
import dagger.Module
import dagger.Provides

@Module
class MapperModule {
    @Provides
    fun provideFilmMapper() : FilmMapper = FilmMapper()
}