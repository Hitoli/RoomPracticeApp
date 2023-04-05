package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.datamodel.quoterepository
import com.example.myapplication.datamodel.quotes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class viewModel(private val quoterepository: quoterepository):ViewModel() {

    fun getquotes():LiveData<List<quotes>>{
         return quoterepository.getquotes()
    }
    fun insertquote(quotes: quotes){
        viewModelScope.launch(Dispatchers.IO) {
            quoterepository.insertquote(quotes)
        }

    }

}