package com.fit.data.repository

import com.fit.data.handleAPICall
import com.fit.data.model.VerifyResponse
import com.fit.data.model.Client
import com.fit.data.model.Resource
import com.fit.data.model.User
import com.fit.data.model.VerifyRequest
import com.fit.data.network.ApiService
import javax.inject.Inject

interface AuthRepository {
    suspend fun createUser(loginRequest: Client): Resource<Client>
    suspend fun verifyEmail(verifyRequest: VerifyRequest): Resource<VerifyResponse>
}

internal class AuthRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): AuthRepository {
    override suspend fun createUser(loginRequest: Client): Resource<Client> =
        handleAPICall { apiService.createUser(loginRequest) }

    override suspend fun verifyEmail(verifyRequest: VerifyRequest): Resource<VerifyResponse> =
        handleAPICall { apiService.verifyEmail(verifyRequest) }
}