package id.ac.unand.loki_a9.retrofit

import com.google.gson.annotations.SerializedName

data class laporSelesaiKP(

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: String? = null
)