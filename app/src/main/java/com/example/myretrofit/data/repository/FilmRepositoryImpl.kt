package com.example.myretrofit.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.myretrofit.data.database.AppDatabase
import com.example.myretrofit.data.database.FilmInfoDao
import com.example.myretrofit.data.mapper.FilmMapper
import com.example.myretrofit.data.network.ApiService
import com.example.myretrofit.domain.FilmInfo
import com.example.myretrofit.domain.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val filmInfoDao: FilmInfoDao,
    private val mapper: FilmMapper,
    private val apiService: ApiService
) : FilmRepository {
    override fun getFilmInfoList(): LiveData<List<FilmInfo>> =
        Transformations.map(filmInfoDao.getFilmList()) {
            mapper.mapListDbModelToListEntity(it)
        }


    override suspend fun getFilmInfo(idFilm: Int): FilmInfo {
        val dbModel = filmInfoDao.getFilmInfo(idFilm)
        return mapper.mapDbModelToEntity(dbModel)

    }

    override suspend fun loadData() {
        val topFilmsListDto = apiService.getTopFilmInfoList()
        val filmListDb = mapper.mapListDtoModelToListDbModel(topFilmsListDto.films!!)
        filmListDb.map { filmInfoDao.addFilmInfo(it) }
    }
}