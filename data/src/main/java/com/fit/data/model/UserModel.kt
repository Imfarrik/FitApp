package com.fit.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("username")
    val name: String,
    val password: String = "password",
    @SerializedName("is_superuser")
    val isSuperuser: Boolean = false,
    @SerializedName("first_name")
    val firstName: String? = null,
    @SerializedName("last_name")
    val lastName: String? = null,
    val email: String,
    @SerializedName("is_verified")
    val isVerified: Boolean = false
)