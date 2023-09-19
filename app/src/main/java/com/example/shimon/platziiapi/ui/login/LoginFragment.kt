package com.example.shimon.platziiapi.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.shimon.platziiapi.R
import com.example.shimon.platziiapi.base.baseFragment
import com.example.shimon.platziiapi.data.models.Login.RequestLogin
import com.example.shimon.platziiapi.databinding.FragmentLoginBinding
import com.example.shimon.platziiapi.utils.Keys
import com.example.shimon.platziiapi.utils.PrefManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : baseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate){



    private val viewModel: LoginViewModel by viewModels()

    @Inject
    lateinit var prefManager: PrefManager



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loginResponse.observe(viewLifecycleOwner) {


            if (it.isSuccessful) {
                binding.progressBar.visibility = View.GONE

                prefManager.setPref(Keys.Access_Token,it.body()?.accessToken!!)
                prefManager.setPref(Keys.Refresh_Token,it.body()?.refreshToken!!)


                findNavController().navigate(R.id.action_loginFragment_to_profileFragment)
               // findNavController().navigate(R.id.action_loginFragment_to_homeFragment)

            }

        }

        binding.RegisterBTN.setOnClickListener {

            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.signInBTN.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE

            val email = binding.emailET.text.toString()
            val password = binding.emailET.text.toString()

            handleLogin("john@mail.com", "changeme")

        }


    }

    private fun handleLogin(email: String, password: String) {

        val requestLogin = RequestLogin(email = email, password = password)
        //fire and forget
        viewModel.login(requestLogin)

    }

}