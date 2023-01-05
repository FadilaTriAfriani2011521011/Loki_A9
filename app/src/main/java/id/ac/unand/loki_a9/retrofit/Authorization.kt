package id.ac.unand.loki_a9.retrofit

import com.google.gson.annotations.SerializedName

data class Authorization(
    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("token")
    val token: String? = null
)
