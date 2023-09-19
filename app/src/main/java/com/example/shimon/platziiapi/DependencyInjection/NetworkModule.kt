package com.example.shimon.platziiapi.DependencyInjection

import com.example.shimon.platziiapi.data.repositories.UserRepository
import com.example.shimon.platziiapi.services.AuthService
import com.example.shimon.platziiapi.services.UploadService
import com.example.shimon.platziiapi.services.UserService
import com.example.shimon.platziiapi.utils.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder {

        return Retrofit.Builder()
            .baseUrl("https://api.escuelajs.co/api/v1/")
            .addConverterFactory(
                GsonConverterFactory.create()
            )
    }

    @Provides
    @Singleton
    fun provideRetrofitAuth(retrofit: Retrofit.Builder) : AuthService{
        return retrofit.build().create(AuthService::class.java)

    }

    @Provides
    @Singleton
    fun provideUpload(retrofit: Retrofit.Builder) : UploadService{
        return retrofit.build().create(UploadService::class.java)

    }

    @Provides
    @Singleton
    fun provideHttpClient(authInterceptor: AuthInterceptor) : OkHttpClient{
        return OkHttpClient.Builder().addInterceptor(interceptor = authInterceptor).build()

    }




    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit.Builder,client: OkHttpClient) : UserService{
        return retrofit.client(client).build().create(UserService::class.java)

    }



}