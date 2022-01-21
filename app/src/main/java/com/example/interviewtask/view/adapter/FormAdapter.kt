package com.example.interviewtask.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.interviewtask.databinding.FormItemBinding
import com.example.interviewtask.model.FormModel

class FormAdapter(val formList: List<FormModel>, val formSubmitListener: FormSubmitListener) : RecyclerView.Adapter<FormViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormViewHolder {

        return FormViewHolder(FormItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),formSubmitListener)
    }

    override fun onBindViewHolder(holder: FormViewHolder, position: Int) {
        holder.bind(formList.get(position))
    }

    override fun getItemCount(): Int {
        return formList.size
    }

    interface FormSubmitListener{

       fun onSubmitClick(formModel: FormModel)
    }
}