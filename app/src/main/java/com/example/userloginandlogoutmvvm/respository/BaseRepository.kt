package com.example.userloginandlogoutmvvm.respository

import com.example.userloginandlogoutmvvm.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {
    //Will inherit this to actual repository

    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): Resource<T>{
        //returns  a respurce of type T

        //we  execute the api call
        return withContext(Dispatchers.IO){
            try {
                Resource.Success(apiCall.invoke())
            }catch (throwable: Throwable){
                when(throwable){
                    is HttpException ->{
                        Resource.Failure(false,throwable.code(),throwable.response()?.errorBody())
                    }
                    else -> {
                        Resource.Failure(true,null, null)
                    }
                }
            }

        }

    }

}