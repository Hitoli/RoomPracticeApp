package com.example.myapplication.view

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.datamodel.QuotesDatabase
import com.example.myapplication.datamodel.quoterepository
import com.example.myapplication.viewmodel.viewModel
import com.example.myapplication.viewmodel.viewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModelMain:viewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dao = QuotesDatabase.getDatabase(applicationContext).quoteDao()
        val repository = quoterepository(dao)

        viewModelMain = ViewModelProvider(this,viewModelFactory(repository)).get(viewModel::class.java)

        viewModelMain.getquotes().observe(this, Observer{
            binding.Quotesitis.text = it.toString()
        })

        binding.NextQuotes.setOnClickListener {
            //TODO
         }

    }
}