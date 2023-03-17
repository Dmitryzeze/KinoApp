package com.example.myretrofit.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.myretrofit.domain.FilmInfo

class FilmInfoDiffCallback : DiffUtil.ItemCallback<FilmInfo>() {
    override fun areItemsTheSame(oldItem: FilmInfo, newItem: FilmInfo): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: FilmInfo, newItem: FilmInfo): Boolean {
        return oldItem==newItem
    }

}
