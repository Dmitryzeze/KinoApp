package com.example.myretrofit.presentation.main.rv

import androidx.recyclerview.widget.DiffUtil
import com.example.myretrofit.domain.FilmFromListInfo

class FilmInfoDiffCallback : DiffUtil.ItemCallback<FilmFromListInfo>() {
    override fun areItemsTheSame(oldItem: FilmFromListInfo, newItem: FilmFromListInfo): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: FilmFromListInfo, newItem: FilmFromListInfo): Boolean {
        return oldItem==newItem
    }

}
