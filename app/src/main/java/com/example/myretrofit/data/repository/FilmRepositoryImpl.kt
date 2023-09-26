package com.example.myretrofit.data.repository


import android.util.Log
import androidx.lifecycle.asLiveData
import com.example.myretrofit.data.database.cache.FilmInfoDao
import com.example.myretrofit.data.database.favorite.FavoriteFilmListDao
import com.example.myretrofit.data.mapper.FilmMapper
import com.example.myretrofit.data.network.ApiService
import com.example.myretrofit.domain.FilmFromListInfo
import com.example.myretrofit.domain.FilmInfo
import com.example.myretrofit.domain.FilmRepository
import com.example.myretrofit.domain.StaffFromFilm
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val filmInfoDao: FilmInfoDao,
    private val favoriteFilmListDao: FavoriteFilmListDao,
    private val mapper: FilmMapper,
    private val apiService: ApiService
) : FilmRepository {
    private val _cacheFilmList = MutableStateFlow(emptyList<FilmFromListInfo>())
    val cacheFilmList
        get() = _cacheFilmList.asStateFlow()
fun list () {
    _cacheFilmList.asLiveData()}
    override fun getFilmInfoList(): Flow<List<FilmFromListInfo>> =
        filmInfoDao.getFilmList().map { listFilm ->
            if (listFilm.isEmpty()) {
                try {
                    loadFilmsFromServerToBd()
                } catch (e: Exception) {
                    Log.e(e.toString(), "KinoApp")
                }
            }
            mapper.mapListDbModelToListEntity(listFilm).onEach { filmFromList ->
                favoriteFilmListDao.getFilmInfo(filmFromList.id).collect {
                    filmFromList.favoriteFlag = it
                }
            }
        }

    private fun getFilmListFromBd

    override suspend fun deleteFilmFromFavorite(filmFromList: FilmFromListInfo) {
        favoriteFilmListDao.deleteFilmInfo(filmFromList.id)
    }

    override suspend fun addFilmToFavorite(filmFromList: FilmFromListInfo) {
        favoriteFilmListDao.addFilmInfo(mapper.mapEntityToDto(filmFromList))
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