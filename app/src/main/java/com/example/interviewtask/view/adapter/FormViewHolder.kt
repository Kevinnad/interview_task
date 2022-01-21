package com.example.interviewtask.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.interviewtask.databinding.FormItemBinding
import com.example.interviewtask.model.FormModel

class FormViewHolder(
    val formItemBinding: FormItemBinding,
    val formSubmitListener: FormAdapter.FormSubmitListener
) : RecyclerView.ViewHolder(formItemBinding.root) {

    fun bind(item: FormModel) {

        formItemBinding.etEmail.setText(item.email)
        formItemBinding.etName.setText(item.name)
        formItemBinding.etMobile.setText(item.mobile)

        formItemBinding.btSubmit.setOnClickListener {
            submitForm(item)
        }
    }

    fun submitForm(formModel: FormModel) {

        formModel.name = formItemBinding.etName.text.toString()
        formModel.email = formItemBinding.etEmail.text.toString()
        formModel.mobile = formItemBinding.etMobile.text.toString()

        formSubmitListener.onSubmitClick(formModel)
    }
}