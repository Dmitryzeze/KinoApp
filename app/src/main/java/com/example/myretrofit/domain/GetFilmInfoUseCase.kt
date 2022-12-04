package com.example.myretrofit.domain

class GetFilmInfoUseCase(
    private val repository: FilmRepository
) {
    operator fun invoke(idFilm: Int)= repository.getFilmInfo(idFilm)
}