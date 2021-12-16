package com.example.labot2.database.relationshipTEST

import androidx.room.Embedded
import com.example.labot2.models.Movies

data class MovieList (

    @Embedded
    val movies: MutableList<Movies>


        )