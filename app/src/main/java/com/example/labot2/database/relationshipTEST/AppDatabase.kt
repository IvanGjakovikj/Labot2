package com.example.labot2.database.relationshipTEST

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.labot2.database.relationshipTEST.dao.MovieListDao
import com.example.labot2.models.Movies

@Database(entities = [Movies::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun MovieListDao(): MovieListDao

    private lateinit var instance: AppDatabase

    fun getInstance(context: Context): AppDatabase{
        if(instance== null){
            instance =createInstace(context)
        }
        return instance
    }

    private fun createInstace(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "MovieList.db"
        ).build()
    }

}