package com.example.myretrofit.data.repository


import com.example.myretrofit.data.database.cache.FilmInfoDao
import com.example.myretrofit.data.mapper.FilmMapper
import com.example.myretrofit.data.network.ApiService
import com.example.myretrofit.domain.FilmFromListInfo
import com.example.myretrofit.domain.FilmInfo
import com.example.myretrofit.domain.FilmRepository
import com.example.myretrofit.domain.StaffFromFilm
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val filmInfoDao: FilmInfoDao,
    private val mapper: FilmMapper,
    private val apiService: ApiService
) : FilmRepository {
    private val _map = mutableMapOf<Int, List<FilmFromListInfo>>()
    private val map: Map<Int, List<FilmFromListInfo>>
        get() = _map

    override fun getFilmInfoList(): Flow<List<FilmFromListInfo>> =
        filmInfoDao.getFilmList().map {
            if (it.isEmpty()) {
                loadFilmsFromServerToBd()
            }
            mapper.mapListDbModelToListEntity(it)
        }

    override fun getFilmInfo(idFilm: Int): Flow<FilmInfo> = flow {
        val filmInfoDto = apiService.getFilmInfo(idFilm)
        emit( mapper.mapDtoModelToEntity(filmInfoDto))
    }

    override suspend fun loadFilmsFromServerToBd() {
        for (page in 1..13) {
            val topFilmsListDto = apiService.getTopFilmInfoList(page)
            val filmListDb = mapper.mapListDtoModelToListDbModel(topFilmsListDto.films)
            filmListDb.map { filmInfoDao.addFilmInfo(it) }
        }
    }
    override fun loadStaffFilmFromServer(idFilm: Int): Flow<List<StaffFromFilm>> = flow{
        val staffListFromFilmDto = apiService.getStaffFilm(idFilm)
        val staffListFromFilmEntity = staffListFromFilmDto.map{mapper.mapDtoModelToEntity(it)}
        emit( staffListFromFilmEntity)
    }
}