package com.example.myretrofit.data.database

import androidx.room.*
import com.example.myretrofit.data.database.cache.FilmInfoDao
import com.example.myretrofit.data.database.cache.FilmOfListInfoDbModel


@Database(
    entities = [FilmOfListInfoDbModel::class],
    version = 2,
    exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun filmInfoDao() : FilmInfoDao
}

