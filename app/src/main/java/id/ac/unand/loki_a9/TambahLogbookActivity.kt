package id.ac.unand.loki_a9

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import id.ac.unand.loki_a9.databinding.ActivityLogbookBinding
import id.ac.unand.loki_a9.databinding.ActivityTambahLogbookBinding
import id.ac.unand.loki_a9.retrofit.Config
import id.ac.unand.loki_a9.retrofit.Login
import id.ac.unand.loki_a9.retrofit.TambahLogbookResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TambahLogbookActivity : AppCompatActivity() {
    private lateinit var Back6 : ImageView
    lateinit var binding :ActivityTambahLogbookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahLogbookBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val Back6 = binding.Back6
//        Back6.setOnClickListener {
//            intent = Intent(applicationContext, ListLogbookActivity::class.java)
//            startActivity(intent)
//        }
    }
    fun onClickedd(view: View) {
        val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?:return
        val token = sharedPref.getString("TOKEN",null)
        val kegiatan = binding.inputkegiatanku.text.toString()
        val client : Login = Config().getService()
        val call : Call<TambahLogbookResponse> = client.tambah_logbook(token=" Bearer "+token,5,kegiatan)
        call.enqueue(object :Callback<TambahLogbookResponse>{
            override fun onResponse(
                call: Call<TambahLogbookResponse>,
                response: Response<TambahLogbookResponse>
            ) {
                val respon : TambahLogbookResponse? = response.body()
                Log.d("isiiii",respon.toString())
                if (respon!=null && respon.status =="success"){
                    Log.d("isi-logbook","$token|$respon")
                    intent = Intent(applicationContext,ListLogbookActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    Toast.makeText(this@TambahLogbookActivity, "Berhasil DiRespon", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                    finish()
                }
            }

            override fun onFailure(call: Call<TambahLogbookResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}