package com.example.myretrofit.presentation.main.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myretrofit.R
import com.example.myretrofit.domain.FilmFromListInfo

class MainFragmentRVAdapter :
    androidx.recyclerview.widget.ListAdapter<FilmFromListInfo, MainFragmentRVHolder>(FilmInfoDiffCallback()) {
    var onShopItemClickListener: ((FilmFromListInfo)-> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainFragmentRVHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_film_info,
            parent,
            false
        )
        return MainFragmentRVHolder(view)
    }


    override fun onBindViewHolder(holder: MainFragmentRVHolder, position: Int) {
        val filmItem = getItem(position)
        holder.bind(filmItem)
        holder.view.setOnClickListener {
            onShopItemClickListener?.invoke(filmItem)


        }
    }
}