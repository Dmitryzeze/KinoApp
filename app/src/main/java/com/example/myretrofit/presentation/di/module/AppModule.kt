package com.example.myretrofit.presentation.di.module
import dagger.Module;

@Module(
    includes = [DataBaseModule::class,
        RepositoryModule::class,
        MapperModule::class,
        ApiServiceModule::class
    ]
)
class AppModule