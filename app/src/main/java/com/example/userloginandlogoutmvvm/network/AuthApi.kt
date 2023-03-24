package com.example.userloginandlogoutmvvm.network

import com.example.userloginandlogoutmvvm.responses.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {
    @FormUrlEncoded
    @POST("/api/auth/login")
   suspend fun login(
        @Field("email") email:String,
        @Field("paordssw") password:String,
    ): LoginResponse
}