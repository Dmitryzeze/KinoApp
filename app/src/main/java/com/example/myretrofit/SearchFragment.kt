package com.example.myretrofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

import com.example.myretrofit.data.NetworkService
import com.example.myretrofit.data.ResponseModel
import com.example.myretrofit.databinding.FragmentSearchBinding
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSearchBinding.inflate(
            inflater, container, false
        )
        val buttonLike = binding.buttonLike
        val poster = binding.poster
        val buttonNext = binding.buttonNext
        val loggingInterceptor: HttpLoggingInterceptor =
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
        val retrofit = NetworkService(client)
        var count : Int = 300
        buttonNext.setOnClickListener {
            retrofit.getJSON().getAllPhotos("${count++}").enqueue(object : Callback<ResponseModel> {
                override fun onResponse(
                    call: Call<ResponseModel>,
                    response: Response<ResponseModel>
                ) {
                    val resp: ResponseModel? = response.body()
                    if (response.isSuccessful) {
                        Glide.with(this@SearchFragment).load(resp?.posterURL).fitCenter().transform(
                        ).into(poster)

                    }

                }

                override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                }

            })


        }
        buttonLike.setOnClickListener { }
        // Inflate the layout for this fragment
        return binding.root
    }


}