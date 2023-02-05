package com.example.myretrofit.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myretrofit.R

class MainFragmentRVHolder (val view : View): RecyclerView.ViewHolder(view){
    val ivIconFilm : ImageView = view.findViewById(R.id.iv_icon_film)
    val tvNameFilm : TextView= view.findViewById(R.id.tv_name_film)
}