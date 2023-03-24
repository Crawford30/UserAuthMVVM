package com.example.userloginandlogoutmvvm.data.responses.network

import com.example.userloginandlogoutmvvm.data.responses.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {
    @FormUrlEncoded
    @POST("/api/auth/login")
   suspend fun login(
        @Field("email") email:String,
        @Field("password") password:String,
    ): LoginResponse
}