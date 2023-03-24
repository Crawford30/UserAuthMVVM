package com.example.userloginandlogoutmvvm.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope

import com.example.userloginandlogoutmvvm.databinding.FragmentLoginBinding
import com.example.userloginandlogoutmvvm.data.network.AuthApi
import com.example.userloginandlogoutmvvm.data.network.Resource
import com.example.userloginandlogoutmvvm.data.respository.AuthRepository
import com.example.userloginandlogoutmvvm.ui.base.BaseFragment
import com.example.userloginandlogoutmvvm.ui.enable
import com.example.userloginandlogoutmvvm.ui.home.HomeActivity
import com.example.userloginandlogoutmvvm.ui.startNewActivity
import com.example.userloginandlogoutmvvm.ui.visible
import kotlinx.coroutines.launch


class LoginFragment : BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepository>() {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.progressbar.visible(false)
        binding.buttonLogin.enable(false)

    viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
    binding.progressbar.visible(true)
    when (it) {
        is Resource.Success -> {



            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
            lifecycleScope.launch {

                viewModel.saveAuthToken(it.value.token.toString())
//                        viewModel.saveAccessTokens(
//                            it.value.user.access_token!!,
//                            it.value.user.refresh_token!!
//                        )
                requireActivity().startNewActivity(HomeActivity::class.java)
            }
        }
        is Resource.Failure -> {
            Toast.makeText(requireContext(), "Login Failure", Toast.LENGTH_LONG).show()
        }
    }
})


        binding.editTextTextPassword.addTextChangedListener {
            val email = binding.editTextTextEmailAddress.text.toString().trim()
            binding.buttonLogin.enable(email.isNotEmpty() && it.toString().isNotEmpty())
        }

        binding.buttonLogin.setOnClickListener {

            val email = binding.editTextTextEmailAddress.text.toString().trim()
            val password = binding.editTextTextPassword.text.toString().toString()


            //hit the api using view model
            binding.progressbar.visible(true)
            viewModel.login(email, password)
        }
    }

    override fun getViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    )  = FragmentLoginBinding.inflate(inflater,container,false)


    //instance of remote data source, to create api instance
    override fun getFragmentRepository() = AuthRepository(remoteDataSource.buildApi(AuthApi::class.java), userPreferences )


}