package com.example.userloginandlogoutmvvm.ui.base

import androidx.lifecycle.ViewModel
import com.example.userloginandlogoutmvvm.data.network.AuthApi
import com.example.userloginandlogoutmvvm.data.respository.BaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


abstract  class BaseViewModel(private val  repository: BaseRepository):ViewModel() {
  suspend fun logout(api: AuthApi) = withContext(Dispatchers.IO){repository.logout(api)}
}