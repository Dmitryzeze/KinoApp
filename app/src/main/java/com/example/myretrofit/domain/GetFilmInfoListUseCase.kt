package com.example.myretrofit.domain

class GetFilmInfoListUseCase(
    private val repository: FilmRepository
) {
    operator fun invoke()= repository.getFilmInfoList()
}