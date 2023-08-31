package com.example.myretrofit.data.database.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmInfoDao {
    @Query("SELECT * From full_film_list")
    fun getFilmList(): Flow<List<FilmOfListInfoDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFilmInfo(shopItemDbModel: FilmOfListInfoDbModel)

    @Query("DELETE FROM full_film_list WHERE id =:filmId")
    suspend fun deleteFilmInfo(filmId: Int)

    @Query("SELECT * FROM full_film_list WHERE id =:filmId LIMIT 1")
    fun getFilmInfo(filmId: Int): Flow<FilmOfListInfoDbModel>
}