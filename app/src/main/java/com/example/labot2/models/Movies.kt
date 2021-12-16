package com.example.labot2.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TESTING")
data class Movies(
    @PrimaryKey val id: Int,
    var title: String,
    val plot: String,
    val actors: String,
    val posterUrl: String,
    val director: String
)