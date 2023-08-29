package com.example.myretrofit.data.repository

import com.example.myretrofit.R
import com.example.myretrofit.data.database.FilmInfoDao
import com.example.myretrofit.data.database.FilmOfListInfoDbModel
import com.example.myretrofit.data.mapper.FilmMapper
import com.example.myretrofit.data.network.ApiService
import com.example.myretrofit.domain.FilmFromListInfo
import com.example.myretrofit.domain.FilmInfo
import com.example.myretrofit.domain.FilmRepository
import com.example.myretrofit.domain.ProfessionKey
import com.example.myretrofit.domain.StaffFromFilm
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FilmRepoMockImpl @Inject constructor(
    private val filmInfoDao: FilmInfoDao,
    private val mapper: FilmMapper,
    private val apiService: ApiService


) : FilmRepository {
    private val _map = mutableMapOf<Int, List<FilmFromListInfo>>()
    private val map: Map<Int, List<FilmFromListInfo>>
        get() = _map

    override fun getFilmInfoList(): Flow<List<FilmFromListInfo>> = flow {

        val listFilmInfo = Array(100) { id ->
            FilmFromListInfo(
                id,
                "Film Name",
                "1997",
                listOf("com"),
                "8.0",
                "8.0",
                "8.0"
            )
        }.toList()
        emit(listFilmInfo)
    }


    override fun getFilmInfo(idFilm: Int): Flow<FilmInfo> =
        flow {
            val filmInfo = FilmInfo(
                1,
                "test",
                "test",
                "test",
                "https://kinopoiskapiunofficial.tech/images/posters/kp/389.jpg",
                5.0,
                5.0,
                "https://kinopoiskapiunofficial.tech/images/posters/kp/389.jpg",
                2010,
                "The best film in the world dsjkgfjklsdagh jkfsdgjkfhsd akfhsdakfh jsdkljfh asdljkafh sdjklahfasd jkhsdjklhasdjklg hsdjklfg hsdajklfgsdhjkl hasdjkghasdjk fghasdkjfg hjklgasdghjkadsffghasdfjklghasdf jklgadsfgh jkasdfgh asdjkffgh asdfjkfhsdfjklasdhfgljkasdhfgjklasfv jkashgjkasdgh klajghasdv asdgasdfgasdfg dfsgfsdgdfgsdfgsdfgsdfgsdfgsdfgdfgsdfg",
                "2",
                "15",
                listOf("rus"),
                listOf("serial"),
            )
            emit(filmInfo)
        }

    override suspend fun loadFilmsFromServerToBd() {
        for (page in 1..13) {
            val topFilmsListDto = apiService.getTopFilmInfoList(page)
            val filmListDb = mapper.mapListDtoModelToListDbModel(topFilmsListDto.films)
            filmListDb.map { filmInfoDao.addFilmInfo(it) }
        }
    }

    override fun loadStaffFilmFromServer(idFilm: Int): Flow<List<StaffFromFilm>> =
        flow {
            val staffListFromFilmEntity = Array(5) { index ->
                StaffFromFilm(
                    index,
                    "dima$index",
                    "dima",
                    "BEST",
                    "R.drawable.basepich",
                    "ACTOR",
                    ProfessionKey.ACTOR
                )
            }.toList()
            emit(staffListFromFilmEntity)
        }
}


