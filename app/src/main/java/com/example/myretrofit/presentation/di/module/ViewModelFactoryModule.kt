package com.example.myretrofit.presentation.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.myretrofit.presentation.MyViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface ViewModelFactoryModule {
    @Binds
    fun bindsViewModelFactoryModule(factory: MyViewModelFactory):ViewModelProvider.Factory

}