package com.example.interviewtask.database

import android.content.Context
import androidx.room.Room
import javax.inject.Inject

class DataBaseProvider @Inject constructor(val context: Context) {

    fun createDB() : FormDataBase{

        return Room.databaseBuilder(
            context,
            FormDataBase::class.java, "form-database"
        ).build()

    }
}