package com.example.myretrofit.data.mapper

import androidx.room.TypeConverter
import com.example.myretrofit.data.database.FilmInfoDbModel
import com.example.myretrofit.data.network.model.FilmListInfoDto
import com.example.myretrofit.domain.FilmInfo

class FilmMapper {
    fun mapDtoModelToEntity(dto: FilmListInfoDto): FilmInfo{
        return FilmInfo(
            id = dto.filmId,
            name = dto.nameRu.orEmpty(),
            releaseYear = dto.year.orEmpty(),
            genres = dto.genres.map { it.genre },
            imageUrl = dto.posterUrl.orEmpty(),
            ratingKinopoisk = "",
            ratingImdb = ""
        )
    }
    private fun mapDtoModelToDbModel(dto: FilmListInfoDto): FilmInfoDbModel {
        return FilmInfoDbModel(
            id = dto.filmId,
            name = dto.nameRu.orEmpty(),
            releaseYear = dto.year.orEmpty(),
            genres = dto.genres.map { it.genre },
            imageUrl = dto.posterUrl.orEmpty(),
            ratingKinopoisk = "",
            ratingImdb = ""

        )
    }

    fun mapDbModelToEntity(filmInfoDbModel: FilmInfoDbModel): FilmInfo =
        FilmInfo(
            id = filmInfoDbModel.id,
            name = filmInfoDbModel.name,
            releaseYear = filmInfoDbModel.releaseYear,
            genres = filmInfoDbModel.genres,
            imageUrl = filmInfoDbModel.imageUrl,
            ratingKinopoisk = filmInfoDbModel.ratingKinopoisk,
            ratingImdb = filmInfoDbModel.ratingImdb

        )

    fun mapListDbModelToListEntity(list: List<FilmInfoDbModel>) = list.map {
        mapDbModelToEntity(it)
    }

    fun mapListDtoModelToListDbModel(list: List<FilmListInfoDto>) = list.map {
        mapDtoModelToDbModel(it)
    }
    fun mapListDtoModelToListEntity(list: List<FilmListInfoDto>) = list.map {
        mapDtoModelToEntity(it)
    }
}