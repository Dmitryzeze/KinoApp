package com.example.myretrofit.data.database

import androidx.room.TypeConverter
import androidx.room.TypeConverters

@TypeConverters
class Converters {
    @TypeConverter
    fun stringToList(string: String): List<String> {
        return string.split(",")
    }

    @TypeConverter
    fun listToString(list: List<String>): String {
        return list.joinToString(",")
    }
}