package com.example.interviewtask.datastore

import com.example.interviewtask.model.FormModel
import com.example.interviewtask.network.ResultWrapper

interface FormDataStore {

    suspend fun getFormDataList() : ResultWrapper<List<FormModel>>

    suspend fun insertForm(formModel: FormModel) : ResultWrapper<List<FormModel>>
}