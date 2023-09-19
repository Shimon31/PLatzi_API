package com.example.shimon.platziiapi.ui.upload

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shimon.platziiapi.data.models.Profile.ResponseProfile
import com.example.shimon.platziiapi.data.models.upload.ResponseUpload
import com.example.shimon.platziiapi.data.repositories.UploadRepository
import com.example.shimon.platziiapi.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import retrofit2.Response
import java.io.File
import javax.inject.Inject

@HiltViewModel
class UploadViewModel @Inject constructor(private val repo: UploadRepository) : ViewModel() {

    private var _response = MutableLiveData<Response<ResponseUpload>>()
    val uploadResponse: LiveData<Response<ResponseUpload>> = _response




    fun upload(file: MultipartBody.Part) {

        viewModelScope.launch {
            _response.postValue(repo.upload(file))
        }

    }

}