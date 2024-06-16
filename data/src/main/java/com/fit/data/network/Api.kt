package com.fit.data.network

import com.fit.data.model.VerifyResponse
import com.fit.data.model.Client
import com.fit.data.model.User
import com.fit.data.model.VerifyRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {

    /**
     * TODO: java.net.ConnectException: Failed to connect to /127.0.0.1:8000
     */
    @POST("users")
    suspend fun createUser(
        @Body loginRequest: Client
    ): Response<Client>

    @POST("verify_email")
    suspend fun verifyEmail(
        @Body verifyRequest: VerifyRequest
    ): Response<VerifyResponse>
}