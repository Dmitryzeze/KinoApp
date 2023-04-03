package com.example.myretrofit.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.myretrofit.data.database.AppDatabase
import com.example.myretrofit.data.database.FilmInfoDao
import com.example.myretrofit.data.mapper.FilmMapper
import com.example.myretrofit.data.network.ApiService
import com.example.myretrofit.domain.FilmInfo
import com.example.myretrofit.domain.FilmRepository
import java.util.concurrent.Flow
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val filmInfoDao: FilmInfoDao,
    private val mapper: FilmMapper,
    private val apiService: ApiService


) : FilmRepository {
    private val _map = mutableMapOf<Int, List<FilmInfo>>()
    private val map: Map<Int, List<FilmInfo>>
        get() = _map

    override fun getFilmInfoList(): LiveData<List<FilmInfo>> =
        Transformations.map(filmInfoDao.getFilmList()) {
            mapper.mapListDbModelToListEntity(it)
        }


    override suspend fun getFilmInfo(idFilm: Int): FilmInfo {
        val dbModel = filmInfoDao.getFilmInfo(idFilm)
        return mapper.mapDbModelToEntity(dbModel)

    }

    override suspend fun loadFilmsFromServer(page: Int) {
        val topFilmsListDto = apiService.getTopFilmInfoList()
        val filmListDb = mapper.mapListDtoModelToListDbModel(topFilmsListDto.films!!)
        filmListDb.map { filmInfoDao.addFilmInfo(it) }
    }
    fun filmsFromServer(page: Int){

    }

    fun getFilms(page: Int): Flow<List<FilmInfo>> {
        val result = map[page].orEmpty()
        return if (result.isEmpty()) {
            loadFilmsFromServer(page).map{}

        }
    }
}