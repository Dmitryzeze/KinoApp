package com.example.myretrofit.presentation.di

import android.app.Application
import android.content.Context

class MainApp : Application() {
    val appComponent by lazy {
        DaggerAppComponent.builder().application(this).create()
    }

    val Context.appComponent: AppComponent
    get() = when(this){
        is MainApp -> appComponent
        else->(applicationContext as MainApp).appComponent
    }
}