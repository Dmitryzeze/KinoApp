package com.example.myretrofit.data.mapper

import com.example.myretrofit.data.database.FilmInfoDbModel
import com.example.myretrofit.data.network.model.FilmInfoDto

class FilmMapper  {
    fun mapDtoToDbModel(dto: FilmInfoDto): FilmInfoDbModel{
        return FilmInfoDbModel(
            id= dto.filmId,
                    name= dto.nameRu,
                    releaseYear= dto.year,
                    genre= dto.genres,
                    imageUrl = dto.posterUrl,
                    ratingImdb = dto.
                    rati

        )
    }
}