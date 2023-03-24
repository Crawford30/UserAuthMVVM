package com.example.userloginandlogoutmvvm.data.responses.respository

import com.example.userloginandlogoutmvvm.data.responses.UserPreferences
import com.example.userloginandlogoutmvvm.data.responses.network.AuthApi

class AuthRepository(private val api: AuthApi, private val preferences: UserPreferences) : BaseRepository() {

    //login function that will call the safe api call
   suspend fun login(email:String, password:String) =  safeApiCall {
        api.login(email, password)
    }


//    suspend fun saveAccessTokens(accessToken: String, refreshToken: String) {
//        preferences.saveAccessTokens(accessToken, refreshToken)
//    }

    suspend fun saveAuthToken(token: String) {
        preferences.savedAuthToken(token)
    }

}