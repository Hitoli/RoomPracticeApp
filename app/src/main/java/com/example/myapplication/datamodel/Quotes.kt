package com.example.myapplication.datamodel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class quotes(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val text:String,
    val author:String
)
