package id.ac.unand.loki_a9.retrofit

import retrofit2.Call
import retrofit2.http.*

interface Login {
    @FormUrlEncoded
    @POST("/api/login/")
    fun login(@Field("username") username:String, @Field("password") password:String):Call<LoginResponse>

    @GET("/api/me")
    fun profile(@Header("Authorization") token:String):Call<User>

    @POST("/api/me/update")
    fun updateProfile(@Header("Authorization") token:String)
}