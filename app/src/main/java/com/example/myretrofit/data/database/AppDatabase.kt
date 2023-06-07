package com.example.myretrofit.data.database

import androidx.room.*


@Database(
    entities = [FilmOfListInfoDbModel::class],
    version = 1,
    exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun filmInfoDao() : FilmInfoDao
}

