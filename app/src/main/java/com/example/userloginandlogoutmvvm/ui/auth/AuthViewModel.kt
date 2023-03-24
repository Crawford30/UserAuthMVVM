package com.example.userloginandlogoutmvvm.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userloginandlogoutmvvm.data.network.Resource
import com.example.userloginandlogoutmvvm.data.responses.user.LoginResponse
import com.example.userloginandlogoutmvvm.data.respository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel(private  val repository: AuthRepository): ViewModel() {
    //the view model communicates with the repository
    //By the help of repository we call the function

    private val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponse>>
        get() = _loginResponse

    fun login(
        email: String,
        password: String
    ) = viewModelScope.launch {
       // _loginResponse.value = Resource.Loading
        _loginResponse.value = repository.login(email, password)
    }

    suspend fun saveAuthToken(token: String) = repository.saveAuthToken(token)



//    suspend fun saveAuthToken(token: String) {
//        repository.saveAuthToken(token)
//    }
//    suspend fun saveAccessTokens(accessToken: String, refreshToken: String) {
//        repository.saveAccessTokens(accessToken, refreshToken)
//    }
}