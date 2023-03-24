package com.example.userloginandlogoutmvvm.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.userloginandlogoutmvvm.data.responses.UserPreferences
import com.example.userloginandlogoutmvvm.data.responses.network.RemoteDataSource
import com.example.userloginandlogoutmvvm.data.responses.respository.BaseRepository
import java.util.prefs.Preferences

abstract class BaseFragment<VM:ViewModel,B:ViewBinding, R: BaseRepository>: Fragment() {
    protected lateinit var binding: B
    protected lateinit var viewModel: VM
    protected lateinit var userPreferences: UserPreferences

    //instance of remote data source, to create api instance
    protected  val remoteDataSource = RemoteDataSource()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userPreferences = UserPreferences(requireContext()) //reworked when dependency injection is implemented
        binding = getFragmentBinding(inflater, container)

        //view model instance


        //we need a factory instance
        val factory = ViewModelFactory(getFragmentRepository())

        //we can create view model instance
        viewModel = ViewModelProvider(this,factory).get(getViewModel())


        return binding.root
        //return super.onCreateView(inflater, container, savedInstanceState)
    }

    abstract fun getViewModel(): Class<VM>

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?):B

    abstract fun getFragmentRepository(): R




}