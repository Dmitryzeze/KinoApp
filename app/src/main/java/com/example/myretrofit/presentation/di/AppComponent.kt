package com.example.myretrofit.presentation.di

import android.app.Application
import android.content.Context
import com.example.myretrofit.presentation.FilmViewModel
import com.example.myretrofit.presentation.MainFragment
import com.example.myretrofit.presentation.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(context: Context): Builder
        fun create(): AppComponent
    }

    fun inject(fragment: MainFragment)

}
