package com.example.labot2.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.labot2.models.MovieWrapper

interface MoviesApi {

    @GET("/v3/{id}")
    fun getPlayListByURL(@Path("id") id: String): Call<MovieWrapper >

}