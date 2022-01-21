package com.example.interviewtask.database

import com.example.interviewtask.model.FormModel
import javax.inject.Inject

class FormDataBaseSource @Inject constructor(val formDataBase: FormDataBase) {

    suspend fun insertForm(formModel: FormModel){
        formDataBase.formDao().insert(formModel)
    }

    suspend fun insertAllForm(formModelList: List<FormModel>){
        formDataBase.formDao().insertAll(formModelList)
    }

    suspend fun getFormList() : List<FormModel>?{
        return formDataBase.formDao().getAll()
    }
}