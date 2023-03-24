package com.example.userloginandlogoutmvvm.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.userloginandlogoutmvvm.R
import com.example.userloginandlogoutmvvm.data.network.Resource
import com.example.userloginandlogoutmvvm.data.network.SongApi
import com.example.userloginandlogoutmvvm.data.responses.song.Song
import com.example.userloginandlogoutmvvm.data.responses.song.SongResponse
import com.example.userloginandlogoutmvvm.data.respository.SongRepository
import com.example.userloginandlogoutmvvm.databinding.FragmentHomeBinding
import com.example.userloginandlogoutmvvm.ui.base.BaseFragment
import com.example.userloginandlogoutmvvm.ui.handleApiError
import com.example.userloginandlogoutmvvm.ui.presenttensesong.PresentTenseViewModel
import com.example.userloginandlogoutmvvm.ui.visible
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking


class HomeFragment : BaseFragment<PresentTenseViewModel,FragmentHomeBinding, SongRepository>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //call the funtion to get the songs

        viewModel.getPresentTenseSongs()

        //observer the songs
        viewModel.presentTenseSong.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Success -> {
                    binding.progressbar.visible(false)
                    Toast.makeText(context?.applicationContext, "Present Tense Songs: ${it}" , Toast.LENGTH_LONG).show()

                    Log.d("HomeFragment", "Present Tense Songs: ${it.value.results}")
                   // updateUI(it.value.results.toString())
                    
                }

                is Resource.Loading -> {
                    binding.progressbar.visible(true)
                }

                is Resource.Failure -> {
                    handleApiError(it)
                }
            }
        })

        binding.buttonLogout.setOnClickListener {
            logout()
        }
    }

//    private fun updateUI(song: Song) {
//
//    }

    override fun getViewModel() = PresentTenseViewModel::class.java
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun getFragmentRepository(): SongRepository {
        //create an instance of song repository which needs an instance of a SongApi
        val token = runBlocking {
            userPreferences.authToken.first()
        }

        //1. api instance
        val api = remoteDataSource.buildApi(SongApi::class.java, token)

        return SongRepository(api)
    }


}