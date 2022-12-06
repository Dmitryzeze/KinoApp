package com.example.myretrofit.data.mapper

import com.example.myretrofit.data.database.FilmInfoDbModel
import com.example.myretrofit.data.network.model.FilmListInfoDto

class FilmMapper {
    fun mapDtoToDbModel(dto: FilmListInfoDto): FilmInfoDbModel {
        return FilmInfoDbModel(
            id = dto.filmId,
            name = dto.nameRu.orEmpty(),
            releaseYear = dto.year.orEmpty(),
            genre = dto.genres.orEmpty() as List<String>,
            imageUrl = dto.posterUrl.orEmpty(),
            ratingKinopoisk = "",
            ratingImdb = ""

        )
    }
}