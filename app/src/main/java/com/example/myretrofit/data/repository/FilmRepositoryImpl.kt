package com.example.myretrofit.data.repository


import android.util.Log
import com.example.myretrofit.data.database.cache.FilmInfoDao
import com.example.myretrofit.data.database.favorite.FavoriteFilmListDao
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
    private val favoriteFilmListDao: FavoriteFilmListDao,
    private val mapper: FilmMapper,
    private val apiService: ApiService
) : FilmRepository {
    override fun getFilmInfoList(): Flow<List<FilmFromListInfo>> =
        filmInfoDao.getFilmList().map { listFilm ->
            if (listFilm.isEmpty()) {
                try {
                    loadFilmsFromServerToBd()
                } catch (e:Exception){
                    Log.e(e.toString(), "KinoApp")
                }
            }
            mapper.mapListDbModelToListEntity(listFilm).onEach { filmFromList ->
                if (favoriteFilmListDao.getFilmInfo(filmFromList.id)) {
                    Log.d("error133",favoriteFilmListDao.getFilmInfo(filmFromList.id).toString())
                    filmFromList.favoriteFlag = true
                }
            }
        }

    fun getFavoriteFilmsList(): Flow<List<FilmFromListInfo>> =
        favoriteFilmListDao.getFilmList().map {
            mapper.mapListDbModelToListEntity(it)
                .onEach { filmFromListInfo -> filmFromListInfo.favoriteFlag = true }
        }

    override fun getFilmInfo(idFilm: Int): Flow<FilmInfo> = flow {
        val filmInfoDto = apiService.getFilmInfo(idFilm)
        emit(mapper.mapDtoModelToEntity(filmInfoDto))
    }

    fun getFilmInfoFromDB(idFilm: Int): Flow<FilmFromListInfo> = flow {
        val filmInfoDB = filmInfoDao.getFilmInfo(idFilm)
        emit(mapper.mapDbModelToEntity(filmInfoDB))
    }

    override suspend fun loadFilmsFromServerToBd() {
        for (page in 1..13) {
            val topFilmsListDto = apiService.getTopFilmInfoList(page)
            val filmListDb = mapper.mapListDtoModelToListDbModel(topFilmsListDto.films)
            filmListDb.map { filmInfoDao.addFilmInfo(it) }
        }
    }

    override fun loadStaffFilmFromServer(idFilm: Int): Flow<List<StaffFromFilm>> = flow {
        val staffListFromFilmDto = apiService.getStaffFilm(idFilm)
        val staffListFromFilmEntity = staffListFromFilmDto.map { mapper.mapDtoModelToEntity(it) }
        emit(staffListFromFilmEntity)
    }
}