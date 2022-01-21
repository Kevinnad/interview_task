package com.example.interviewtask.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.interviewtask.model.FormModel

@Dao
interface FormDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(formModel: FormModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(formModelList: List<FormModel>)

    @Query("SELECT * FROM formmodel ORDER BY name")
    suspend fun getAll() : List<FormModel>?
}