package com.fit.data.model

import com.google.gson.annotations.SerializedName

data class Client(
    val id: Int? = null,
    val user: User? = null,
    val sex: String? = null,
    val birthday: String? = null,
    val height: Int = 0,
    val weight: Int = 0,
): ResponseModel {
    override fun toString(): String =
        "id = $id\n" +
        "name = ${user?.name}\n" +
                "password = ${user?.password}\n" +
                "email = ${user?.email}\n" +
                "user is verified = ${user?.isVerified}"
}

data class VerifyRequest(
    val code: String? = null,
)

data class VerifyResponse(
    @SerializedName("code")
    val token: String? = null,
): ResponseModel