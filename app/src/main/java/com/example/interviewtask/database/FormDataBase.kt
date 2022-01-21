package com.example.interviewtask.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.interviewtask.model.FormModel

@Database(entities = [FormModel::class], version = 1)
abstract class FormDataBase : RoomDatabase() {

    abstract fun formDao() : FormDao
}