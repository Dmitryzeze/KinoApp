package com.example.myretrofit.data.mapper

import com.example.myretrofit.data.database.FilmOfListInfoDbModel
import com.example.myretrofit.data.network.model.FilmFromListInfoDto
import com.example.myretrofit.data.network.model.FilmInfoDto
import com.example.myretrofit.data.network.model.StaffFilmDto
import com.example.myretrofit.domain.FilmFromListInfo
import com.example.myretrofit.domain.FilmInfo
import com.example.myretrofit.domain.ProfessionKey
import com.example.myretrofit.domain.StaffFromFilm

class FilmMapper {
    fun mapDtoModelToEntity(dto: FilmFromListInfoDto): FilmFromListInfo {
        return FilmFromListInfo(
            id = dto.filmId,
            name = dto.nameRu.orEmpty(),
            releaseYear = dto.year.orEmpty(),
            genres = dto.genres.map { it.genre },
            imageUrl = dto.posterUrl.orEmpty(),
            ratingKinopoisk = "",
            ratingImdb = ""
        )
    }

    fun mapDtoModelToEntity(dto: FilmInfoDto): FilmInfo {
        return FilmInfo(
            kinopoiskId =dto.kinopoiskId,
            nameRu =dto.nameRu.orEmpty(),
            nameEn =dto.nameEn.orEmpty(),
            nameOriginal =dto.nameOriginal.orEmpty(),
            posterUrl =dto.posterUrlPreview,
            ratingKinopoisk =dto.ratingKinopoisk,
            ratingImdb =dto.ratingImdb,
            webUrl =dto.webUrl.orEmpty(),
            year =dto.year,
            type =dto.type,
            ratingAgeLimits = dto.ratingAgeLimits.orEmpty(),
            countries = dto.countries.map{ it.country},
            description = dto.description,
            genres = dto.genres.map{ it.genre}
        )

    }

    fun mapDtoModelToEntity(dto: StaffFilmDto) = StaffFromFilm(

        staffId = dto.staffId,
        nameRu = dto.nameRu.orEmpty(),
        nameEn = dto.nameEn.orEmpty(),
        description = dto.description.orEmpty(),
        posterUrl = dto.posterUrl,
        professionText = dto.professionKey,
        professionKey = ProfessionKey.valueOf(dto.professionKey)
    )

    private fun mapDtoModelToDbModel(dto: FilmFromListInfoDto): FilmOfListInfoDbModel {
        return FilmOfListInfoDbModel(

            id = dto.filmId,
            name = dto.nameRu.orEmpty(),
            releaseYear = dto.year.orEmpty(),
            genres = dto.genres.map { it.genre },
            imageUrl = dto.posterUrl.orEmpty(),
            ratingKinopoisk = "",
            ratingImdb = ""

        )
    }

    fun mapDbModelToEntity(filmInfoDbModel: FilmOfListInfoDbModel): FilmFromListInfo =
        FilmFromListInfo(
            id = filmInfoDbModel.id,
            name = filmInfoDbModel.name,
            releaseYear = filmInfoDbModel.releaseYear,
            genres = filmInfoDbModel.genres,
            imageUrl = filmInfoDbModel.imageUrl,
            ratingKinopoisk = filmInfoDbModel.ratingKinopoisk,
            ratingImdb = filmInfoDbModel.ratingImdb

        )

    fun mapListDbModelToListEntity(list: List<FilmOfListInfoDbModel>) = list.map {
        mapDbModelToEntity(it)
    }

    fun mapListDtoModelToListDbModel(list: List<FilmFromListInfoDto>) = list.map {
        mapDtoModelToDbModel(it)
    }

    fun mapListDtoModelToListEntity(list: List<FilmFromListInfoDto>) = list.map {
        mapDtoModelToEntity(it)
    }
}