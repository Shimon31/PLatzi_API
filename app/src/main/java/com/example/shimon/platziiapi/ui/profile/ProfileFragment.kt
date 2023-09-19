package com.example.shimon.platziiapi.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import coil.load
import coil.request.CachePolicy
import com.example.shimon.platziiapi.R
import com.example.shimon.platziiapi.base.baseFragment
import com.example.shimon.platziiapi.databinding.FragmentProfileBinding
import com.example.shimon.platziiapi.utils.load
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : baseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    private val viewModel: ProfileViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.profileResponse.observe(viewLifecycleOwner) {

            if (!it.isSuccessful) return@observe

            binding.apply {
                it.body()?.let { profile ->
                    nameTextView.text = profile.name
                    emailTextView.text = profile.email
                    roleTextView.text = profile.role


                   avatarImageView.load(profile.avatar)


                }

            }

        }


    }

}