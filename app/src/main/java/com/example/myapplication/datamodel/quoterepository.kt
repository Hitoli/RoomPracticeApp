package com.example.myapplication.datamodel

import androidx.lifecycle.LiveData

class quoterepository(private var quoteDAO: quoteDAO) {
// accessing data should always in suspend not in main thread
    fun getquotes():LiveData<List<quotes>>{
    //live data is always suspend
        return quoteDAO.getQuotes()
    }
    suspend fun insertquote(quotes: quotes){
        quoteDAO.insertquote(quotes)
    }

}