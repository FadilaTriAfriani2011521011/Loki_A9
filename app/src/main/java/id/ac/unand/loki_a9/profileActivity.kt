package id.ac.unand.loki_a9

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.view.View
import android.widget.Toast
import android.util.Log
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory.config
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import id.ac.unand.loki_a9.retrofit.Login
import id.ac.unand.loki_a9.retrofit.UpdateProfilResponse
import id.ac.unand.loki_a9.retrofit.User
import id.ac.unand.loki_a9.retrofit.Config
import id.ac.unand.loki_a9.databinding.ActivityProfileBinding

class profileActivity : AppCompatActivity() {
    private lateinit var Home2 : ImageView
    lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?:return
        val token = sharedPref.getString("TOKEN", null)

        Log.d("profile", token.toString())
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val client : Login = Config().getService()
        val call : Call<User> = client.profile("Bearer "+token)

        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                val respon = response.body()
                Log.d("profile-debug", "respon : "+ respon)

                val getNama = respon?.name
                binding.Nama.text = getNama

                val email = respon?.email
                binding.Email.text = email

                val username = respon?.username
                binding.NIM.text = username

            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("profile-debug", t.localizedMessage)
            }

        })


        supportActionBar?.hide()

        val btnLogout: Button = findViewById(R.id.logout)
        btnLogout.setOnClickListener{
            val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE)
            with (sharedPref.edit()) {
                putString("token", null)
                apply()
            }

            intent = Intent(applicationContext, loginActivity::class.java)
            startActivity(intent)
            finish()
        }

//        val sharedPref = getSharedPreferences("prefs",Context.MODE_PRIVATE) ?: return
//        val ada = sharedPref.getString("token",null)
//
//        if (ada==null){
//            intent = Intent(applicationContext, loginActivity::class.java)
//            startActivity(intent)
//            finish()
//        }

        val btn: Button = findViewById(R.id.button110)
        btn.setOnClickListener {
            intent = Intent(this, edit_profileActivity::class.java)
            startActivity(intent)
        }
        Home2 = findViewById(R.id.Home2)
        Home2.setOnClickListener {
            intent = Intent(applicationContext, homescreenActivity::class.java)
            startActivity(intent)
        }
    }
}