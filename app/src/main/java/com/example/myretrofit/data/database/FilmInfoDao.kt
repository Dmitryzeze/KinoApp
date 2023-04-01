package com.example.myretrofit.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import javax.inject.Inject

@Dao
interface FilmInfoDao {
    @Query("SELECT * From full_film_list")
    fun getFilmList(): LiveData<List<FilmInfoDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFilmInfo(shopItemDbModel: FilmInfoDbModel)

    @Query("DELETE FROM full_film_list WHERE id =:filmId")
    suspend fun deleteFilmInfo(filmId: Int)

    @Query("SELECT * FROM full_film_list WHERE id =:filmId LIMIT 1")
    suspend fun getFilmInfo(filmId: Int): FilmInfoDbModel
}