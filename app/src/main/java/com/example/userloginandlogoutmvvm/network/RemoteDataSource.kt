package com.example.userloginandlogoutmvvm.network

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource {
    companion object {
        private const val BASE_URL = "http://10.0.2.2:8000"
    }


    fun <Api> buildApi(
        api: Class<Api>
    ): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }


}