package com.example.myretrofit.presentation

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myretrofit.R

class MainFragmentRVAdapter() : RecyclerView.Adapter<MainFragmentRVHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainFragmentRVHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_film_info,
            parent,
            false
        )
        return  MainFragmentRVHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MainFragmentRVHolder, position: Int) {
        TODO("Not yet implemented")
    }
}