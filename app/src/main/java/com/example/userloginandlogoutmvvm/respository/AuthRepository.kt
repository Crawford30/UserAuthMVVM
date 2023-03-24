package com.example.userloginandlogoutmvvm.respository

import com.example.userloginandlogoutmvvm.network.AuthApi

class AuthRepository(private val api: AuthApi) : BaseRepository() {

    //login function that will call the safe api call
   suspend fun login(email:String, password:String) =  safeApiCall {
        api.login(email, password)
    }


//    suspend fun saveAccessTokens(accessToken: String, refreshToken: String) {
//        preferences.saveAccessTokens(accessToken, refreshToken)
//    }

}