package com.example.myretrofit.data.database

import androidx.room.*


@Database(
    entities = [FilmInfoDbModel::class],
    version = 2,
    exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun filmInfoDao() : FilmInfoDao
}

