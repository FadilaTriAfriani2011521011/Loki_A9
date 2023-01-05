package id.ac.unand.loki_a9.retrofit

import retrofit2.Call
import retrofit2.http.*

interface Login {
    @FormUrlEncoded
    @POST("/api/login/")
    fun login(@Field("username") username:String, @Field("password") password:String):Call<LoginResponse>

    @GET("/api/me")
    fun profile(@Header("Authorization") token:String):Call<User>

    @FormUrlEncoded
    @POST("/api/me/update")
    fun updateProfile(
        @Header("Authorization") token:String,
        @Field("name") name:String,
        @Field("email") email:String
    ):Call<UpdateProfilResponse>

    @FormUrlEncoded
    @POST("/api/password")
    fun updatePassword(
        @Header("Authorization")token: String,
        @Field("old_password") old_password:String,
        @Field("new_password") new_password:String,
        @Field("confirm_password") confirm_password:String
    ):Call<ChangePasswordResponse>

    @FormUrlEncoded
    @POST("/api/my-internship/1/finish-statement")
    fun laporSelesaiKP(
        @Header("Authorization") token: String,
    ):Call<laporSelesaiKP>

    @FormUrlEncoded
    @POST("/api/attend-seminar-internship/1")
    fun IsiAbsenSeminarKP(
        @Header("Authorization")token: String,
    ):Call<AbsenResponse>


//    @POST("/api/logout")
//    fun logout(@Header("Authorization") token: String):Call<LogoutResponse>
}