package com.fit.data.network

import com.fit.data.model.VerifyResponse
import com.fit.data.model.Client
import com.fit.data.model.User
import com.fit.data.model.VerifyRequest
import retrofit2.Response
import javax.inject.Inject

interface ApiService {
    suspend fun createUser(loginRequest: Client): Response<Client>
    suspend fun verifyEmail(verifyRequest: VerifyRequest): Response<VerifyResponse>
}

internal class ApiServiceImpl @Inject constructor(
    private val api: Api
): ApiService {
    override suspend fun createUser(loginRequest: Client): Response<Client> =
        api.createUser(loginRequest)

    override suspend fun verifyEmail(verifyRequest: VerifyRequest): Response<VerifyResponse> =
        api.verifyEmail(verifyRequest)
}