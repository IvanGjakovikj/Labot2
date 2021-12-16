package com.example.labot2.models
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class MovieWrapper {
    @SerializedName("movies")
    @Expose
    var movies: MutableList<Movies>? = null

    constructor(movies: MutableList<Movies>) {
        this.movies = movies
    }
}