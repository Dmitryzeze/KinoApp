package com.example.myretrofit.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.myretrofit.R

class MainFragmentRVHolder ( view : View): RecyclerView.ViewHolder(view){
    val ivIconFilm : ImageView = view.findViewById(R.id.iv_icon_film)
    val cardFilmInfo : CardView = view.findViewById(R.id.card_film_info)
    val tvNameFilm : TextView= view.findViewById(R.id.tv_name_film)
}