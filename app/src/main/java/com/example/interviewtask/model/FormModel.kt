package com.example.interviewtask.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class FormModel(
    @PrimaryKey
    @SerializedName("_id") var id: String,

    @SerializedName("name") var name: String,

    @SerializedName("email")var email: String,
    @SerializedName("mobile")var mobile: String,
    @SerializedName("gender")var gender: Int
)
