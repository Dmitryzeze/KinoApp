package com.example.myretrofit.data.database

import android.app.Application
import androidx.room.*
import com.example.myretrofit.data.mapper.FilmMapper


@Database(entities = [FilmInfoDbModel::class], version = 2, exportSchema = true)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun FilmInfoDao(): FilmInfoDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        private var LOCK = Any()
        private const val DB_NAME = "Film.db"

        fun getInstance(application: Application): AppDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    AppDatabase::class.java,
                    DB_NAME
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = db
                return db

            }
        }
    }
}
