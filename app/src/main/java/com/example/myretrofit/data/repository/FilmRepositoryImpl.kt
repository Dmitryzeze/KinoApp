package com.example.myretrofit.data.repository


import com.example.myretrofit.data.database.FilmInfoDao
import com.example.myretrofit.data.mapper.FilmMapper
import com.example.myretrofit.data.network.ApiService
import com.example.myretrofit.domain.FilmInfo
import com.example.myretrofit.domain.FilmRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val filmInfoDao: FilmInfoDao,
    private val mapper: FilmMapper,
    private val apiService: ApiService


) : FilmRepository {
    private val _map = mutableMapOf<Int, List<FilmInfo>>()
    private val map: Map<Int, List<FilmInfo>>
        get() = _map

    override fun getFilmInfoList(): Flow<List<FilmInfo>> =
        filmInfoDao.getFilmList().map {
            if (it.isEmpty()) {
                loadFilmsFromServer()
            }
            mapper.mapListDbModelToListEntity(it)
        }


    override suspend fun getFilmInfo(idFilm: Int): FilmInfo {
        val dbModel = filmInfoDao.getFilmInfo(idFilm)
        return mapper.mapDbModelToEntity(dbModel)

    }

    override suspend fun loadFilmsFromServer() {
        for (page in 1..13) {
            val topFilmsListDto = apiService.getTopFilmInfoList(page)
            val filmListDb = mapper.mapListDtoModelToListDbModel(topFilmsListDto.films)
            filmListDb.map { filmInfoDao.addFilmInfo(it) }
        }
    }
}