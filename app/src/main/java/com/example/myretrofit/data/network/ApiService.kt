package com.example.myretrofit.data.network


import com.example.myretrofit.data.network.model.FilmInfoDto
import com.example.myretrofit.data.network.model.FilmListContainerDto
import com.example.myretrofit.data.network.model.FilmStaffContainerDto
import com.example.myretrofit.data.network.model.StaffFilmDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("v2.2/films/top")
    suspend fun getTopFilmInfoList(
        @Query(QUERY_PAGE_TOP) page: Int = 1,
        @Header(HEADER_API_KEY) api_key: String = API_KEY,
        @Query(QUERY_TYPE_TOP) type: String = "TOP_250_BEST_FILMS"
    ): FilmListContainerDto

    @GET("v2.2/films/{id}")
    suspend fun getFilmInfo(
        @Path(QUERY_ID_FILM) id: Int,
        @Header(HEADER_API_KEY) api_key: String = API_KEY
    ): FilmInfoDto

    @GET("v1/staff")
    suspend fun getStaffFilm(
        @Query(QUERY_ID_FILM_FOR_STAFF) filmId: Int,
        @Header(HEADER_API_KEY) api_key: String = API_KEY
    ): List<StaffFilmDto>

    companion object {
        private const val QUERY_ID_FILM_FOR_STAFF = "filmId"
        private const val QUERY_ID_FILM = "id"
        private const val QUERY_TYPE_TOP = "type"
        private const val QUERY_PAGE_TOP = "page"
        private const val HEADER_API_KEY = "X-API-KEY"
        private const val API_KEY = "566b7a18-0645-42de-b410-d8c2f717b660"
    }
}