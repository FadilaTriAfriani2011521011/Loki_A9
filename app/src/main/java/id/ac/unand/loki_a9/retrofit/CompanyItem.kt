package id.ac.unand.loki_a9.retrofit

import com.google.gson.annotations.SerializedName
import java.net.Inet4Address

data class CompanyItem(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("address")
    val address: String? = null,

    @field:SerializedName("status")
    val status: Int? = null,

    @field:SerializedName("created_at")
    val created_at: Any? = null,

    @field:SerializedName("updated_at")
    val updated_at: Any? = null,


)
