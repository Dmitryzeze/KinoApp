package com.example.myretrofit.domain

class GetFilmInfoUseCase(
    private val repository: FilmRepository
) {
    suspend operator fun invoke(idFilm: Int)= repository.getFilmInfo(idFilm)
}