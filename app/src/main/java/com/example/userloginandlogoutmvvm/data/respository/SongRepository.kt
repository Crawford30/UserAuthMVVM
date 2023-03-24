package com.example.userloginandlogoutmvvm.data.respository

import com.example.userloginandlogoutmvvm.data.responses.user.UserPreferences
import com.example.userloginandlogoutmvvm.data.network.AuthApi
import com.example.userloginandlogoutmvvm.data.network.SongApi

class SongRepository(private val api: SongApi) : BaseRepository() {

suspend fun getSongPresentTenseSong() = safeApiCall {
    api.getPresentTenseSong()
}

}