package com.example.shimon.platziiapi.data.repositories

import com.example.shimon.platziiapi.data.models.Login.RequestLogin
import com.example.shimon.platziiapi.data.models.Login.ResponseLogin
import com.example.shimon.platziiapi.data.models.Registration.RequestRegistration
import com.example.shimon.platziiapi.data.models.Registration.ResponseRegistration
import com.example.shimon.platziiapi.services.AuthService
import retrofit2.Response
import javax.inject.Inject

class AuthRepository @Inject constructor(private val service: AuthService) {

  suspend fun login(requestLogin: RequestLogin) : Response<ResponseLogin> {
       return service.login(requestLogin)

    }
    suspend fun registration(requestRegistration: RequestRegistration) : Response<ResponseRegistration> {
        return service.registration(requestRegistration)

    }

}