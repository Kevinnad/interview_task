package com.example.interviewtask.repository

import com.example.interviewtask.model.FormModel
import com.example.interviewtask.network.ResultWrapper

interface FormRepository {

    suspend fun getFormList() : ResultWrapper<List<FormModel>>

    suspend fun updateForm(formModel: FormModel) : ResultWrapper<List<FormModel>>
}