package com.example.shimon.platziiapi.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shimon.platziiapi.data.models.Login.RequestLogin
import com.example.shimon.platziiapi.data.models.Login.ResponseLogin
import com.example.shimon.platziiapi.data.repositories.AuthRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repo: AuthRepository) : ViewModel() {

    private var _response = MutableLiveData<Response<ResponseLogin>>()
    val loginResponse: LiveData<Response<ResponseLogin>> = _response


    fun login(requestLogin: RequestLogin) {

        viewModelScope.launch {

            _response.postValue(repo.login(requestLogin))
        }

    }

}