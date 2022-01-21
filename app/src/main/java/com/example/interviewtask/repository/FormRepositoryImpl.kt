package com.example.interviewtask.repository

import com.example.interviewtask.datastore.FormDataStore
import com.example.interviewtask.model.FormModel
import com.example.interviewtask.network.ResultWrapper
import javax.inject.Inject

class FormRepositoryImpl @Inject constructor(val dataStore: FormDataStore) : FormRepository {


    override suspend fun getFormList(): ResultWrapper<List<FormModel>> = dataStore.getFormDataList()

    override suspend fun updateForm(formModel: FormModel): ResultWrapper<List<FormModel>> =
        dataStore.insertForm(formModel)

}