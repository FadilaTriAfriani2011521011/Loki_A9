package id.ac.unand.loki_a9.retrofit

import retrofit2.http.POST
import id.ac.unand.loki_a9.datamodels.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded

interface Login {
    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponse?>?
}