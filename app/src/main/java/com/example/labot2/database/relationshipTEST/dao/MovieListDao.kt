package com.example.labot2.database.relationshipTEST.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.labot2.models.Movies

abstract class MovieListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertMovies(movies: MutableList<Movies>)

    fun insertMovieList(movies: MutableList<Movies>){

        try{
            insertMovies(movies)
        }
        catch (ex: Exception){
            ex.printStackTrace()
        }
    }

}