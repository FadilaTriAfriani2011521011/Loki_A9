package id.ac.unand.loki_a9

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.util.Log
import android.view.View
import android.widget.Button
import id.ac.unand.loki_a9.databinding.ActivityGantiPassBinding
import id.ac.unand.loki_a9.retrofit.ChangePasswordResponse
import id.ac.unand.loki_a9.retrofit.Config
import id.ac.unand.loki_a9.retrofit.Login
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ganti_passActivity : AppCompatActivity() {
    lateinit var binding: ActivityGantiPassBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGantiPassBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn: Button = findViewById(R.id.button211)
        btn.setOnClickListener {
//            intent = Intent(this, edit_profileActivity::class.java)
//            startActivity(intent)
            val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?: return@setOnClickListener
            val token = sharedPref.getString("TOKEN",null)

            val old_password = binding.passLama.text.toString()
            val new_password = binding.passBaru.text.toString()
            val confirm_password = binding.confirmPass.text.toString()

            val client: Login = Config().getService()
            val call: Call<ChangePasswordResponse> = client.updatePassword(token = "Bearer $token", old_password, new_password,confirm_password)
            Log.d("update-debug", "$old_password|$new_password|$confirm_password|Bearer $token")

            call.enqueue(object: Callback<ChangePasswordResponse> {
                override fun onFailure(call: Call<ChangePasswordResponse>, t: Throwable) {
                    Log.d("update-debug",t.localizedMessage)
                }
                override fun onResponse(call: Call<ChangePasswordResponse>, response: Response<ChangePasswordResponse>) {
                    Log.d("update-debug", "response : $response")

                    val respon: ChangePasswordResponse? = response.body()
                    if (respon != null && respon.status == "success" && new_password == confirm_password) {

                        Log.d("update-debug", "$old_password:$new_password|$confirm_password|$token|$respon")

                        Toast.makeText(this@ganti_passActivity, "Berhasil Mengupdate password", Toast.LENGTH_SHORT).show()

                        intent = Intent(applicationContext, profileActivity::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        Toast.makeText(this@ganti_passActivity, "Password & Confirm Passowrd Salah", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }
}