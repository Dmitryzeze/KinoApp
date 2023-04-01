package com.example.myretrofit

import android.app.Application
import android.content.Context
import com.example.myretrofit.di.AppComponent
import com.example.myretrofit.di.DaggerAppComponent

class MainApp : Application() {
    val appComponent by lazy {
        DaggerAppComponent.builder().application(this).create()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApp -> appComponent
        else -> (applicationContext as MainApp).appComponent
    }
