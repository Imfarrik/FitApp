package com.fit.data.di

import com.fit.data.BuildConfig
import com.fit.data.network.Api
import com.fit.data.network.ApiService
import com.fit.data.network.ApiServiceImpl
import com.fit.data.repository.AuthRepository
import com.fit.data.repository.AuthRepositoryImpl
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
//            .addInterceptor(HeaderInterceptor(configService))
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    if (BuildConfig.DEBUG) {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    }
                }
            )
            .connectTimeout(60000, TimeUnit.MILLISECONDS)
            .readTimeout(60000, TimeUnit.MILLISECONDS)
            .callTimeout(60000, TimeUnit.MILLISECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideApi(okHttpClient: OkHttpClient): Api {

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            /**
             * TODO: java.lang.IllegalArgumentException:
             *       Unable to create @Body converter for class
             *       com.fit.data.model.LoginRequest (parameter #1)
             */
//            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(Api::class.java)
    }

    @Singleton
    @Provides
    fun provideApiService(api: Api): ApiService = ApiServiceImpl(api)

    @Singleton
    @Provides
    fun provideAuthRepository(
        apiService: ApiService
    ): AuthRepository = AuthRepositoryImpl(apiService)
}


