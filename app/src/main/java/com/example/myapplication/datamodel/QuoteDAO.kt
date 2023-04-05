package com.example.myapplication.datamodel

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface quoteDAO {
    @Query("SELECT * from  quote")
    fun getQuotes():LiveData<List<quotes>>

    @Insert
    suspend fun insertquote(quotes: quotes)
}