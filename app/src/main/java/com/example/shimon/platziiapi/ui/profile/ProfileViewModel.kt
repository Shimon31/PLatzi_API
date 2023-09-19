package com.example.shimon.platziiapi.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shimon.platziiapi.data.models.Profile.ResponseProfile
import com.example.shimon.platziiapi.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repo: UserRepository) : ViewModel() {

    private var _response = MutableLiveData<Response<ResponseProfile>>()
    val profileResponse: LiveData<Response<ResponseProfile>> = _response


    init {
        profile()
    }

   private fun profile() {

        viewModelScope.launch {
            _response.postValue(repo.profile())
        }

    }

}