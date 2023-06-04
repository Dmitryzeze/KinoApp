package com.example.myretrofit.data.network.model

import com.google.gson.annotations.SerializedName

data class FilmStaffContainerDto (
    @SerializedName("staff")
    val staff : List<StaffFilmDto>
)