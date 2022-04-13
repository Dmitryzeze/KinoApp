package com.example.myretrofit.data

import retrofit2.Call
import retrofit2.http.*


interface MyService {
    @Headers("accept: application/json", "X-API-KEY: 566b7a18-0645-42de-b410-d8c2f717b660")
    @GET("/api/v2.2/films/{id}")
    fun getAllPhotos(
        @Path("id") id: String
    ): Call<ResponseModel>
}