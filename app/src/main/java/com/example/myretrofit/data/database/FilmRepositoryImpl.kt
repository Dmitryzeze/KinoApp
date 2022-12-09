package com.example.myretrofit.data.database

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.myretrofit.data.mapper.FilmMapper
import com.example.myretrofit.domain.FilmInfo
import com.example.myretrofit.domain.FilmRepository

class FilmRepositoryImpl(application: Application): FilmRepository {
    private val filmInfoDao = AppDatabase.getInstance(application).FilmInfoDao()
    private val mapper = FilmMapper()

    override fun getFilmInfoList(): LiveData<List<FilmInfo>> {
        TODO("Not yet implemented")
    }

    override fun getFilmInfo(idFilm: Int): LiveData<FilmInfo> {
        TODO("Not yet implemented")
    }
}