package com.example.labot2.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesApiClient {

    companion object {

        private var movieApi: MoviesApi? = null

        fun getUserApi(): MoviesApi? {
            if(movieApi == null){
                movieApi = Retrofit.Builder()
                    .baseUrl("https://run.mocky.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(MoviesApi::class.java)
            }
            return movieApi
        }
    }
}