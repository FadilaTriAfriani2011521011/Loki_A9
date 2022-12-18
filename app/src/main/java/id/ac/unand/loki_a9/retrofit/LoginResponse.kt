package id.ac.unand.loki_a9.retrofit

import com.google.gson.annotations.SerializedName
import id.ac.unand.loki_a9.retrofit.User

data class LoginResponse(
    @field:SerializedName("authorisation")
    val authorisation: Authorization? = null,

    @field:SerializedName("user")
    val user: User? = null,

    @field:SerializedName("status")
    val status: String? = null
)