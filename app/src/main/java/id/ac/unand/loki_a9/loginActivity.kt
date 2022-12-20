package id.ac.unand.loki_a9

import android.content.Context
import android.content.Intent
import android.os.Binder
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
import id.ac.unand.loki_a9.databinding.ActivityLoginBinding
import id.ac.unand.loki_a9.retrofit.Config
import id.ac.unand.loki_a9.retrofit.Login
import id.ac.unand.loki_a9.retrofit.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class loginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        }

    fun onButtonLoginClicked(view: View) {
        val username = binding.editEmail.text.toString()
        val password = binding.editPassword.text.toString()

        val client: Login = Config().getService()

        val call: Call<LoginResponse> = client.login(username,password)

        call.enqueue(object: Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.d("login-debug",t.localizedMessage)
                Toast.makeText(this@loginActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                //ambil respon login
                val respon: LoginResponse? = response.body();
                if (respon != null && respon.status == "success" ) {

                    //ambil Token
                    val token = respon.authorisation?.token
                    Log.d("login-debug",username +":"+ password +"|"+ token)

                    //Shared Preference
                    val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE) ?:return
                    with (sharedPref.edit()) {
                        putString("TOKEN", token)
                        apply()
                    }
                    Toast.makeText(this@loginActivity, "Login Berhasil", Toast.LENGTH_SHORT).show()

                    intent = Intent(applicationContext, homescreenActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@loginActivity, "Username atau Password yang anda masukkan salah", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }


}
