package com.example.myretrofit.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myretrofit.data.model.Film
import retrofit2.Response

class FilmRepository (private val filmService: FilmService) {
    private val _films: MutableLiveData<List<Film>> = MutableLiveData(emptyList())
    val films: LiveData<List<Film>>
        get() = _films

    fun startListeningFilms(count: Int) {
        val filmList = mutableListOf<Film>()
        val response: Response<Film> = filmService.getFilm(count)
        if (response.isSuccessful && response.body() != null) {
            filmList.add(response.body()!!)
            _films.postValue(filmList)
        }}
        /*for (n in 0..20){
        val response: Response<Film> = filmService.getFilm(count+n)
        if (response.isSuccessful && response.body() != null) {
            filmList[n] = response.body()!!
        }}
        _films.postValue(filmList)
    }*/
    }
