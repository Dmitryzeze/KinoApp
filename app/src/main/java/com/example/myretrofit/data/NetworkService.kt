package com.example.myretrofit.data

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class NetworkService(client: OkHttpClient) {

    private val mRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    fun getJSON (): MyService{
        return mRetrofit.create(MyService::class.java)
    }
    companion object {
        private const val BASE_URL = "https://kinopoiskapiunofficial.tech/"
    }


}
