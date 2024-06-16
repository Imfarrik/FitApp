package com.fit.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("username")
    val name: String,
    val password: String,
    @SerializedName("is_superuser")
    val isSuperuser: Boolean,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val email: String,
    @SerializedName("is_verified")
    val isVerified: Boolean
): ResponseModel {
    override fun toString(): String =
        "name = $name\n" +
                "password = $password\n" +
                "email = $email\n" +
                "user is verified = $isVerified"
}