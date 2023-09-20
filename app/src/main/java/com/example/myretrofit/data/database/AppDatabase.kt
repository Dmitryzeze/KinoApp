package com.example.myretrofit.data.database

import androidx.room.*
import com.example.myretrofit.data.database.cache.FilmInfoDao
import com.example.myretrofit.data.database.cache.FilmOfListInfoDbModel
import com.example.myretrofit.data.database.favorite.FavoriteFilmListDao
import com.example.myretrofit.data.database.favorite.FavoriteListFilmDbModel


@Database(
    entities = [FilmOfListInfoDbModel::class,FavoriteListFilmDbModel::class],
    version = 3,
    exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun filmInfoDao() : FilmInfoDao
    abstract fun favoriteFilmListDao() : FavoriteFilmListDao
}

