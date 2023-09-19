package com.example.shimon.platziiapi.services

import com.example.shimon.platziiapi.data.models.Profile.ResponseProfile
import retrofit2.Response
import retrofit2.http.GET

interface UserService {
    @GET("auth/profile")
   suspend fun profile(): Response<ResponseProfile>




}