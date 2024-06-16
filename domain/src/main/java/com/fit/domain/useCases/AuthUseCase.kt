package com.fit.domain.useCases

import com.fit.data.model.VerifyResponse
import com.fit.data.model.Client
import com.fit.data.model.Resource
import com.fit.data.model.User
import com.fit.data.model.VerifyRequest
import com.fit.data.repository.AuthRepository
import com.fit.domain.di.IODispatcher
import com.fit.domain.getResponse
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

interface AuthUseCase {
    suspend fun createUser(loginRequest: Client): Resource<Client>
    suspend fun verifyEmail(verifyRequest: VerifyRequest): Resource<VerifyResponse>
}

internal class AuthUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository,
    @IODispatcher
    private val dispatcher: CoroutineDispatcher
): AuthUseCase {
    override suspend fun createUser(loginRequest: Client): Resource<Client> =
        authRepository.createUser(loginRequest).getResponse(dispatcher)

    override suspend fun verifyEmail(verifyRequest: VerifyRequest): Resource<VerifyResponse> =
        authRepository.verifyEmail(verifyRequest).getResponse(dispatcher)

}