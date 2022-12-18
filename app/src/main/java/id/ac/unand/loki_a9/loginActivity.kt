package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import android.widget.Toast
import android.util.Log
import android.view.View
import id.ac.unand.loki_a9.datamodels.LoginResponse
import id.ac.unand.loki_a9.retrofit.Login
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class loginActivity : AppCompatActivity() {
    lateinit var editEmail: EditText
    lateinit var editPassword: EditText
    lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        cekLogin()

//        supportActionBar?.hide()
//        val btn: Button = findViewById(R.id.buttonLogin)
//        btn.setOnClickListener {
//            intent = Intent(this, homescreenActivity::class.java)
//            startActivity(intent)
        }
fun cekLogin() {
    editEmail = findViewById(R.id.editEmail)
    editPassword = findViewById(R.id.editPassword)
    buttonLogin = findViewById(R.id.buttonLogin)
    buttonLogin.setOnClickListener(View.OnClickListener {
        val API_BASE_URL = "http://ptb-api.husnilkamil.my.id"
        var username = editEmail.getText().toString()
        var password = editPassword.getText().toString()
        val retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
        val client = retrofit.create(Login::class.java)
        val call = client.login(username, password)
        call!!.enqueue(object : Callback<LoginResponse?> {
            override fun onResponse(
                call: Call<LoginResponse?>,
                response: Response<LoginResponse?>
            ) {
                val loginResponse = response.body()
                Log.d("loginResponse", "login response error")
                if (loginResponse != null) {
                    Toast.makeText(this@loginActivity, "Kamu Berhasil Login", Toast.LENGTH_SHORT)
                        .show()
                    val mainIntent = Intent(this@loginActivity, mainActivity::class.java)
                    startActivity(mainIntent)
                }
                else {
                    Toast.makeText(this@loginActivity, "Lengkapi Data Login", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {
                Toast.makeText(this@loginActivity, "Maaf, Kamu Gagal Login", Toast.LENGTH_SHORT).show()
            }
        })
    })

}}
