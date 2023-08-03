package com.example.myretrofit.presentation.film_info

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.myretrofit.domain.FilmFromListInfo
import com.example.myretrofit.domain.FilmInfo
import com.example.myretrofit.domain.FilmRepository
import com.example.myretrofit.domain.StaffFromFilm
import javax.inject.Inject

class FilmInfoViewModel @Inject constructor(
    private val filmsRepository: FilmRepository
) : ViewModel() {
    fun getFilmInfo(id: Int): LiveData<FilmInfo> = filmsRepository.getFilmInfo(id).asLiveData()
    fun getStaffFromFilm(id: Int) : LiveData<List<StaffFromFilm>> = filmsRepository.loadStaffFilmFromServer(id).asLiveData()

}
