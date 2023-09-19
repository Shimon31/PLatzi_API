package com.example.shimon.platziiapi.services

import com.example.shimon.platziiapi.data.models.Login.RequestLogin
import com.example.shimon.platziiapi.data.models.Login.ResponseLogin
import com.example.shimon.platziiapi.data.models.Registration.RequestRegistration
import com.example.shimon.platziiapi.data.models.Registration.ResponseRegistration
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("auth/login")
   suspend fun login(@Body requestLogin: RequestLogin): Response<ResponseLogin>

   @POST("users")
   suspend fun registration(@Body requestRegistration: RequestRegistration): Response<ResponseRegistration>

}