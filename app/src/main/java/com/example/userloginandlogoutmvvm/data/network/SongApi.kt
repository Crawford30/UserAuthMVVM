package com.example.userloginandlogoutmvvm.data.network

import com.example.userloginandlogoutmvvm.data.responses.song.SongResponse
import retrofit2.http.GET

interface SongApi {

    //==Present Tense Song
    @GET("/api/present-tense/list")
    suspend fun getPresentTenseSong():SongResponse
}