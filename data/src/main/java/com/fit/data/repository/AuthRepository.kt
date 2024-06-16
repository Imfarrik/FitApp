package com.fit.data.repository

import com.fit.data.handleAPICall
import com.fit.data.model.AuthResponse
import com.fit.data.model.LoginRequest
import com.fit.data.model.Resource
import com.fit.data.model.User
import com.fit.data.model.VerifyRequest
import com.fit.data.network.ApiService
import javax.inject.Inject

interface AuthRepository {
    suspend fun createUser(loginRequest: LoginRequest): Resource<User>
    suspend fun verifyEmail(verifyRequest: VerifyRequest): Resource<AuthResponse>
}

internal class AuthRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): AuthRepository {
    override suspend fun createUser(loginRequest: LoginRequest): Resource<User> =
        handleAPICall { apiService.createUser(loginRequest) }

    override suspend fun verifyEmail(verifyRequest: VerifyRequest): Resource<AuthResponse> =
        handleAPICall { apiService.verifyEmail(verifyRequest) }
}