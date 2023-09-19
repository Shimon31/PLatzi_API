package com.example.shimon.platziiapi.ui.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.shimon.platziiapi.R
import com.example.shimon.platziiapi.base.baseFragment
import com.example.shimon.platziiapi.data.models.Registration.RequestRegistration
import com.example.shimon.platziiapi.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : baseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    val viewModel: RegistrationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.registrationResponse.observe(viewLifecycleOwner){

            if (it.isSuccessful){

                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)

            }

        }

        binding.registerBTN.setOnClickListener {


            val name = binding.usernameTV.text.toString().trim()
            val email = binding.emailTv.text.toString().trim()
            val password = binding.passTv.text.toString().trim()
            val imageAvatar =
                "https://wallpapers.com/images/hd/funny-pictures-dzujtlgoq3utq7j4.jpg"
            val requestRegistration = RequestRegistration(
                avatar = imageAvatar,
                email = email,
                name = name,
                password = password
            )
             viewModel.registration(requestRegistration)


        }


    }

}