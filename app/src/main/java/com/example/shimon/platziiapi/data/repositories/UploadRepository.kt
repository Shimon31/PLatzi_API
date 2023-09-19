package com.example.shimon.platziiapi.data.repositories

import com.example.shimon.platziiapi.data.models.Login.RequestLogin
import com.example.shimon.platziiapi.data.models.Login.ResponseLogin
import com.example.shimon.platziiapi.data.models.Profile.ResponseProfile
import com.example.shimon.platziiapi.data.models.Registration.RequestRegistration
import com.example.shimon.platziiapi.data.models.Registration.ResponseRegistration
import com.example.shimon.platziiapi.data.models.upload.ResponseUpload
import com.example.shimon.platziiapi.services.AuthService
import com.example.shimon.platziiapi.services.UploadService
import com.example.shimon.platziiapi.services.UserService
import okhttp3.MultipartBody
import retrofit2.Response
import javax.inject.Inject

class UploadRepository @Inject constructor(private val service: UploadService) {


    suspend fun upload(file: MultipartBody.Part) : Response<ResponseUpload> {
        return service.upload(file)

    }

}