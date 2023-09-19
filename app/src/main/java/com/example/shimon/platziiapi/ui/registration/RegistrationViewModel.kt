package com.example.shimon.platziiapi.ui.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shimon.platziiapi.data.models.Login.RequestLogin
import com.example.shimon.platziiapi.data.models.Login.ResponseLogin
import com.example.shimon.platziiapi.data.models.Registration.RequestRegistration
import com.example.shimon.platziiapi.data.models.Registration.ResponseRegistration
import com.example.shimon.platziiapi.data.repositories.AuthRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val repo: AuthRepository) : ViewModel() {

    private var _response = MutableLiveData<Response<ResponseRegistration>>()
    val registrationResponse: LiveData<Response<ResponseRegistration>> = _response


    fun registration(requestRegistration: RequestRegistration) {

        viewModelScope.launch {
            _response.postValue(repo.registration(requestRegistration))
        }

    }

}