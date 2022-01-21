package com.example.interviewtask.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interviewtask.model.FormModel
import com.example.interviewtask.network.ResultWrapper
import com.example.interviewtask.repository.FormRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repository: FormRepository) : ViewModel() {

    val formListLiveData = MutableLiveData<List<FormModel>>()
    val errorValue = MutableLiveData<String>()

    fun fetchFormData(){
        viewModelScope.launch(Dispatchers.Default) {

            val formListResponse = repository.getFormList()

            when(formListResponse){

                is ResultWrapper.Success ->{
                    formListLiveData.postValue(formListResponse.value)
                }
                is ResultWrapper.NetworkError -> {
                    errorValue.postValue(formListResponse.value)
                }
                is ResultWrapper.GenericError -> {
                    errorValue.postValue(formListResponse.value)
                }
            }

        }
    }

    fun updateForm(formModel: FormModel){

        viewModelScope.launch(Dispatchers.Default) {

            val formList = repository.updateForm(formModel)

            when(formList){

                is ResultWrapper.Success ->{
                    formListLiveData.postValue(formList.value)
                }
                is ResultWrapper.NetworkError -> {
                    errorValue.postValue(formList.value)
                }
                is ResultWrapper.GenericError -> {
                    errorValue.postValue(formList.value)
                }
            }
        }
    }
}