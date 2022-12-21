package com.example.myretrofit.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.myretrofit.data.database.AppDatabase
import com.example.myretrofit.data.mapper.FilmMapper
import com.example.myretrofit.data.network.ApiFactory
import com.example.myretrofit.domain.FilmInfo
import com.example.myretrofit.domain.FilmRepository
class FilmRepositoryImpl(application: Application) : FilmRepository {
    private val filmInfoDao = AppDatabase.getInstance(application).FilmInfoDao()
    private val mapper = FilmMapper()
    private val apiService = ApiFactory.apiService

    override fun getFilmInfoList(): LiveData<List<FilmInfo>> =
        Transformations.map(filmInfoDao.getFilmList()) {
            mapper.mapListDbModelToListEntity(it)
        }


    override suspend fun getFilmInfo(idFilm: Int): FilmInfo {
        val dbModel = filmInfoDao.getFilmInfo(idFilm)
        return mapper.mapDbModelToEntity(dbModel)

    }

    override suspend fun loadData() {
        val topFilms = apiService.getTopFilmInfoList()

    }
}