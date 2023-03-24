package com.example.userloginandlogoutmvvm.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.userloginandlogoutmvvm.R
import com.example.userloginandlogoutmvvm.databinding.FragmentLoginBinding
import com.example.userloginandlogoutmvvm.network.AuthApi
import com.example.userloginandlogoutmvvm.network.Resource
import com.example.userloginandlogoutmvvm.respository.AuthRepository
import com.example.userloginandlogoutmvvm.ui.base.BaseFragment


class LoginFragment : BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepository>() {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
    when (it) {
        is Resource.Success -> {
            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
//            lifecycleScope.launch {
////                        viewModel.saveAccessTokens(
////                            it.value.user.access_token!!,
////                            it.value.user.refresh_token!!
////                        )
//                requireActivity().startNewActivity(HomeActivity::class.java)
//            }
        }
        is Resource.Failure -> {
            Toast.makeText(requireContext(), "Login Failure", Toast.LENGTH_LONG).show()
        }
    }
})
        binding.buttonLogin.setOnClickListener {
            val email = binding.editTextTextEmailAddress.text.toString().trim()
            val password = binding.editTextTextPassword.text.toString().toString()

            //@todo add validation
            //hit the api using view model
            viewModel.login(email, password)
        }
    }

    override fun getViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    )  = FragmentLoginBinding.inflate(inflater,container,false)


    //instance of remote data source, to create api instance
    override fun getFragmentRepository() = AuthRepository(remoteDataSource.buildApi(AuthApi::class.java))


}