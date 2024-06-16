package com.fit.data.network

import com.fit.data.model.AuthResponse
import com.fit.data.model.LoginRequest
import com.fit.data.model.User
import com.fit.data.model.VerifyRequest
import retrofit2.Response
import javax.inject.Inject

interface ApiService {
    suspend fun createUser(loginRequest: LoginRequest): Response<User>
    suspend fun verifyEmail(verifyRequest: VerifyRequest): Response<AuthResponse>
}

internal class ApiServiceImpl @Inject constructor(
    private val api: Api
): ApiService {
    override suspend fun createUser(loginRequest: LoginRequest): Response<User> =
        api.createUser(loginRequest)

    override suspend fun verifyEmail(verifyRequest: VerifyRequest): Response<AuthResponse> =
        api.verifyEmail(verifyRequest)
}