package com.example.myretrofit.domain

import java.io.FileDescriptor

data class StaffFromFilm(
    val staffId : Int,
    val nameRu : String,
    val nameEn : String,
    val description : String,
    val posterUrl : String,
    val professionText : String,
    val professionKey : ProfessionKey
)
