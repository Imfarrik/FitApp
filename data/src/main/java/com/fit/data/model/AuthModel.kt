package com.fit.data.model

data class LoginRequest(
    val email: String? = null,
    val name: String? = null,
    val surname: String? = null,
)

data class VerifyRequest(
    val code: String? = null,
)

data class AuthResponse(
    val token: String? = null,
): ResponseModel