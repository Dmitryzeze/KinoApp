package com.example.myretrofit

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myretrofit.data.NetworkService
import com.example.myretrofit.data.NoResponseModel
import com.example.myretrofit.data.ResponseModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textView = findViewById<TextView>(R.id.text)
        val button = findViewById<Button>(R.id.button)

        val loggingInterceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
        button.setOnClickListener {
            val retrofit = NetworkService(client)
            retrofit.getJSON().getAllPhotos("301").enqueue(object : Callback<ResponseModel>{
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                val resp : ResponseModel? = response.body()
                if (response.isSuccessful){

                textView.text = resp?.text()}

            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                textView.text = t.toString()
                Log.d("TAG","$t")
            }

        })
        }
    }
}