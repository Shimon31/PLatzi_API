package com.example.shimon.platziiapi.services

import com.example.shimon.platziiapi.data.models.Profile.ResponseProfile
import com.example.shimon.platziiapi.data.models.upload.ResponseUpload
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface UploadService {


    @Multipart
    @POST("files/upload")
   suspend fun upload(

      @Part file:MultipartBody.Part

   ): Response<ResponseUpload>





}