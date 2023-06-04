package com.example.myretrofit.data.network


import com.example.myretrofit.data.network.model.FilmInfoDto
import com.example.myretrofit.data.network.model.FilmListContainerDto
import com.example.myretrofit.data.network.model.FilmStaffContainerDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("top")
    suspend fun getTopFilmInfoList(
        @Query(QUERY_PARAM_PAGE_TOP) page : Int = 1,
        @Header(QUERY_PARAM_API_KEY) api_key: String = API_KEY,
        @Query(QUERY_PARAM_TYPE_TOP) type: String = "TOP_250_BEST_FILMS"
        ): FilmListContainerDto

    @GET("film")
    suspend fun getFilmInfo(
        @Header(QUERY_PARAM_API_KEY) api_key: String = API_KEY,
        @Query(QUERY_PARAM_ID_FILM) id : Int
    ): FilmInfoDto

    @GET("staff")
    suspend fun getStaffFilm(
        @Header(QUERY_PARAM_API_KEY) api_key: String = API_KEY,
        @Query(QUERY_PARAM_ID_FILM) id : Int
    ) : FilmStaffContainerDto

    companion object{
        private const val QUERY_PARAM_ID_FILM = "id"
        private const val QUERY_PARAM_TYPE_TOP = "type"
        private const val QUERY_PARAM_PAGE_TOP = "page"
        private const val QUERY_PARAM_API_KEY = "X-API-KEY"
        private const val API_KEY ="566b7a18-0645-42de-b410-d8c2f717b660"
    }
}