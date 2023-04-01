package com.example.myretrofit.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.myretrofit.presentation.main.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {
    @Binds
    fun bindsViewModelFactoryModule(factory: ViewModelFactory):ViewModelProvider.Factory

}