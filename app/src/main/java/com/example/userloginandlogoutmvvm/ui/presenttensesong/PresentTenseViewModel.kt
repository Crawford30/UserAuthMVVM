package com.example.userloginandlogoutmvvm.ui.presenttensesong

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userloginandlogoutmvvm.data.network.Resource
import com.example.userloginandlogoutmvvm.data.responses.song.SongResponse
import com.example.userloginandlogoutmvvm.data.respository.SongRepository
import kotlinx.coroutines.launch

class PresentTenseViewModel(
    private val repository: SongRepository
):ViewModel() {
    private val _presentTenseSong:MutableLiveData<Resource<SongResponse>> = MutableLiveData()
    val presentTenseSong:LiveData<Resource<SongResponse>>
    get() = _presentTenseSong


    //Call the function created in the Song Repository

    fun getPresentTenseSongs() = viewModelScope.launch {
        _presentTenseSong.value = repository.getSongPresentTenseSong()
    }
}

