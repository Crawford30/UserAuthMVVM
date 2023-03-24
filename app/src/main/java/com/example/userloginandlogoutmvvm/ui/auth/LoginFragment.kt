package com.example.userloginandlogoutmvvm.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.userloginandlogoutmvvm.R
import com.example.userloginandlogoutmvvm.databinding.FragmentLoginBinding
import com.example.userloginandlogoutmvvm.network.AuthApi
import com.example.userloginandlogoutmvvm.respository.AuthRepository
import com.example.userloginandlogoutmvvm.ui.base.BaseFragment


class LoginFragment : BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepository>() {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun getViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    )  = FragmentLoginBinding.inflate(inflater,container,false)


    //instance of remote data source, to create api instance
    override fun getFragmentRepository() = AuthRepository(remoteDataSource.buildApi(AuthApi::class.java))


}