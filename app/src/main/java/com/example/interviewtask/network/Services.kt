package com.example.interviewtask.network

import com.example.interviewtask.model.FormModel
import com.example.interviewtask.utils.Constant.BASEURL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Services {

    @GET("kevink")
    suspend fun getFormApi(): List<FormModel>


    companion object {

        fun createService(
            httpClient: HttpClientBuilderFactory
        ): Services {

            val okHttpClient = httpClient.create().build()

            return Retrofit.Builder()
                .baseUrl(BASEURL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Services::class.java)
        }
    }
}