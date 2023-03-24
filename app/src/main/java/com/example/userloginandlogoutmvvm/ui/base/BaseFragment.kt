package com.example.userloginandlogoutmvvm.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.example.userloginandlogoutmvvm.respository.BaseRepository

abstract class BaseFragment<VM:ViewModel,B:ViewBinding, R: BaseRepository>: Fragment() {
    protected lateinit var binding: B


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getFragmentBinding(inflater, container)

        return binding.root
        //return super.onCreateView(inflater, container, savedInstanceState)
    }

    abstract fun getViewModel(): Class<VM>

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?):B

    abstract fun getFragmentRepository(): R




}