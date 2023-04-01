package com.example.myretrofit.di.module
import dagger.Module;

@Module(
    includes = [
        ViewModelModule::class,
        ViewModelFactoryModule::class,
        DataBaseModule::class,
        RepositoryModule::class,
        MapperModule::class,
        ApiServiceModule::class
    ]
)
class AppModule