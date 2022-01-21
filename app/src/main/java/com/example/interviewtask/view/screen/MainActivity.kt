package com.example.interviewtask.view.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.interviewtask.R
import com.example.interviewtask.databinding.ActivityMainBinding
import com.example.interviewtask.model.FormModel
import com.example.interviewtask.view.adapter.FormAdapter
import com.example.interviewtask.view.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel : MainViewModel by viewModels()
    private lateinit var activityMainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        observers()
        initView()
    }

    private fun initView() {

        activityMainBinding.btLocation.setOnClickListener {
            startActivity(Intent(this,LocationActivity::class.java))
        }
    }

    fun observers(){

        mainViewModel.fetchFormData()

        mainViewModel.formListLiveData.observe(this,{

            activityMainBinding.formList.adapter = FormAdapter(it, object : FormAdapter.FormSubmitListener{
                override fun onSubmitClick(formModel: FormModel) {
                    mainViewModel.updateForm(formModel)
                }

            })
        })
    }
}