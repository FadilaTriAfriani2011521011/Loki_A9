package id.ac.unand.loki_a9

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import id.ac.unand.loki_a9.databinding.ActivityEditProfileBinding
import id.ac.unand.loki_a9.retrofit.Config
import id.ac.unand.loki_a9.retrofit.Login
import id.ac.unand.loki_a9.retrofit.UpdateProfilResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class edit_profileActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getNama = intent.getStringExtra("Nama")
        val getEmail = intent.getStringExtra("Email")

        binding.editNama.setText(getNama)
        binding.editEmail.setText(getEmail)


        val btnsave: Button = findViewById(R.id.button1000)
        btnsave.setOnClickListener {

            val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?: return@setOnClickListener
            val token = sharedPref.getString("TOKEN",null)

            val name = binding.editNama.text.toString()
            val email = binding.editEmail.text.toString()

            val client: Login = Config().getService()
            val call: Call<UpdateProfilResponse> = client.updateProfile(token = "Bearer $token", name, email)
            Log.d("update-debug", "$name|$email|Bearer $token")

            call.enqueue(object: Callback<UpdateProfilResponse> {
                override fun onFailure(call: Call<UpdateProfilResponse>, t: Throwable) {
                    Log.d("update-debug",t.localizedMessage)
                }
                override fun onResponse(call: Call<UpdateProfilResponse>, response: Response<UpdateProfilResponse>) {
                    Log.d("update-debug", "response : $response")

                    val respon: UpdateProfilResponse? = response.body()
                    if (respon != null && respon.status == "success" ) {

                        Log.d("update-debug", "$name:$email|$token|$respon")

                        Toast.makeText(this@edit_profileActivity, "Berhasil Mengupdate Profile", Toast.LENGTH_SHORT).show()

                        intent = Intent(applicationContext, profileActivity::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        Toast.makeText(this@edit_profileActivity, "Data Yang Anda Inputkan Salah", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }
}