package com.example.interviewtask.datastore

import com.example.interviewtask.database.FormDataBaseSource
import com.example.interviewtask.model.FormModel
import com.example.interviewtask.network.ResultWrapper
import com.example.interviewtask.network.Services
import com.example.interviewtask.network.handleRequest
import javax.inject.Inject

class FormDataStoreImpl @Inject constructor(
    val services: Services,
    val formDataBaseSource: FormDataBaseSource
) : FormDataStore {

    override suspend fun getFormDataList(): ResultWrapper<List<FormModel>> {

        return getForminDB()
    }

    override suspend fun insertForm(formModel: FormModel): ResultWrapper<List<FormModel>> {

        formDataBaseSource.insertForm(formModel)

        return getForminDB()
    }

    suspend fun fetchForms(formsResult: ResultWrapper<List<FormModel>>): ResultWrapper<List<FormModel>> {

        when (formsResult) {
            is ResultWrapper.Success -> {
                return insertForms(formsResult.value)
            }
            is ResultWrapper.NetworkError -> {
                return formsResult
            }
            is ResultWrapper.GenericError -> {
                return formsResult
            }
            else ->
                return formsResult
        }
    }

    suspend fun insertForms(formList: List<FormModel>): ResultWrapper<List<FormModel>> {
        formDataBaseSource.insertAllForm(formList)
        return getForminDB()
    }

    suspend private fun getForminDB(): ResultWrapper<List<FormModel>> {

        val formList = formDataBaseSource.getFormList()

        if (formList != null && formList.size > 0) {
            return handleRequest { formList }
        } else {
            return fetchForms(handleRequest { services.getFormApi() })
        }
    }

}