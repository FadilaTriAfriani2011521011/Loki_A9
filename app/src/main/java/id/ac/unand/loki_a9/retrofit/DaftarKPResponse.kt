package id.ac.unand.loki_a9.retrofit

import com.google.gson.annotations.SerializedName

data class DaftarKPResponse (
    @field:SerializedName("companies")
    val companies: List<CompanyItem?>? = null,

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("status")
    val status: String? = null
        )