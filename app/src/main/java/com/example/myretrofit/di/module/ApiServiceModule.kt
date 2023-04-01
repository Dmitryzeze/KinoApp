package com.example.myretrofit.di.module

import com.example.myretrofit.data.network.ApiFactory
import com.example.myretrofit.data.network.ApiService
import dagger.Module
import dagger.Provides

@Module
class ApiServiceModule {
    @Provides
    fun provideApiService():ApiService =ApiFactory.apiService
}