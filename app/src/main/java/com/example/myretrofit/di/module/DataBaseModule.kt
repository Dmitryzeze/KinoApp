package com.example.myretrofit.di.module

import android.content.Context
import androidx.room.Room
import com.example.myretrofit.data.database.AppDatabase
import com.example.myretrofit.data.database.cache.FilmInfoDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideDataBase(
        context: Context)
    : AppDatabase = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        DATABASE_NAME
    )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideForecastDao(db: AppDatabase): FilmInfoDao = db.filmInfoDao()



    companion object{
        private const val DATABASE_NAME = "film_database"
    }
}