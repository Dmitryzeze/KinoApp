package com.example.myretrofit.di

import android.content.Context
import com.example.myretrofit.presentation.main.MainFragment
import com.example.myretrofit.di.module.AppModule
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
