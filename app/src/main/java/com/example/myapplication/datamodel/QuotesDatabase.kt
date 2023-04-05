package com.example.myapplication.datamodel

import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.room.Room

@Database(entities = [quotes::class], version = 1)
abstract class QuotesDatabase:RoomDatabase() {

    abstract fun quoteDao(): quoteDAO

    companion object{
        private  var INSTANCE: QuotesDatabase? =null
        fun getDatabase(context:Context): QuotesDatabase {
            if(INSTANCE ==null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context, QuotesDatabase::class.java,"quote_database")
                        .createFromAsset("quotes.db")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}