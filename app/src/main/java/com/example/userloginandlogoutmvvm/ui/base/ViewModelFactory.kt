package com.example.userloginandlogoutmvvm.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.userloginandlogoutmvvm.data.responses.respository.AuthRepository
import com.example.userloginandlogoutmvvm.data.responses.respository.BaseRepository
import com.example.userloginandlogoutmvvm.ui.auth.AuthViewModel
import java.lang.IllegalArgumentException


//To give the view model
class ViewModelFactory(private  val  repository: BaseRepository):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return super.create(modelClass)
      return  when {
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T
          // modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T

            else -> throw IllegalArgumentException("View Model Class Not Found")
        }
    }
}