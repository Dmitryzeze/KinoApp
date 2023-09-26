package com.example.myretrofit.data.database.favorite

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myretrofit.data.database.cache.FilmOfListInfoDbModel
import kotlinx.coroutines.flow.Flow
@Dao
interface FavoriteFilmListDao {
    @Query("SELECT * From favorite_film_list")
    fun getFilmList(): Flow<List<FilmOfListInfoDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFilmInfo(favoriteFilmDbModel: FavoriteFilmFromListDbModel)

    @Query("DELETE FROM favorite_film_list WHERE id =:filmId")
    suspend fun deleteFilmInfo(filmId: Int)

    @Query("SELECT EXISTS(SELECT * FROM favorite_film_list WHERE id =:filmId LIMIT 1)")
    fun getFilmInfo(filmId: Int):  Flow<Boolean>
}