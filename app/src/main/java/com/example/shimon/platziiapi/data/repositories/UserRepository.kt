package com.example.shimon.platziiapi.data.repositories

import com.example.shimon.platziiapi.data.models.Login.RequestLogin
import com.example.shimon.platziiapi.data.models.Login.ResponseLogin
import com.example.shimon.platziiapi.data.models.Profile.ResponseProfile
import com.example.shimon.platziiapi.data.models.Registration.RequestRegistration
import com.example.shimon.platziiapi.data.models.Registration.ResponseRegistration
import com.example.shimon.platziiapi.services.AuthService
import com.example.shimon.platziiapi.services.UserService
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(private val service: UserService) {


    suspend fun profile() : Response<ResponseProfile> {
        return service.profile()

    }

}