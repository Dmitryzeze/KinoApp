package com.example.myretrofit.data.network


import com.example.myretrofit.data.network.model.FilmContainerDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("top")
    suspend fun getTopFilmInfoList(
        @Header(QUERY_PARAM_API_KEY) api_key: String = API_KEY,
        @Query(QUERY_PARAM_TYPE_TOP) type: String = "TOP_250_BEST_FILMS",
        @Query(QUERY_PARAM_PAGE_TOP) page : Int = 1
        ): FilmContainerDto

    companion object{
        private const val QUERY_PARAM_TYPE_TOP = "type"
        private const val QUERY_PARAM_PAGE_TOP = "page"
        private const val QUERY_PARAM_API_KEY = "X-API-KEY"
        private const val API_KEY ="566b7a18-0645-42de-b410-d8c2f717b660"
    }
}