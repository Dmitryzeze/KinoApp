package com.example.myretrofit.data

import com.example.myretrofit.data.model.Film
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface FilmService {
    @Headers("accept: application/json", "X-API-KEY: 566b7a18-0645-42de-b410-d8c2f717b660")
    @GET("/api/v2.2/films/{id}")
    fun getFilm(
        @Path("id") id: Int
    ): Response<Film>
}