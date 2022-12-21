package com.example.myretrofit.domain

class LoadDataUseCase (
    private val repository : FilmRepository
){
    suspend operator fun invoke() = repository.loadData()
}