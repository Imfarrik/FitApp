package com.fit.data.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("username")
    val userName: String? = null,
    val password: String? = "password",
//    @SerializedName("first_name")
//    val firstName: String = "",
//    @SerializedName("last_name")
//    val lastName: String = "",
    val email: String? = null,
)

data class VerifyRequest(
    val code: String? = null,
)

data class AuthResponse(
    @SerializedName("code")
    val token: String? = null,
): ResponseModel