package id.ac.unand.loki_a9

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import id.ac.unand.loki_a9.databinding.ActivityLogbookBinding
import id.ac.unand.loki_a9.retrofit.Config
import id.ac.unand.loki_a9.retrofit.DetailLogbookResponse
import id.ac.unand.loki_a9.retrofit.Login
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogbookActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogbookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogbookBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?:return
        val logbookRef = getSharedPreferences("logbookpref",Context.MODE_PRIVATE)?:return
        val token = sharedPref.getString("TOKEN",null)
        val id = sharedPref.getInt("id",2)
        val IDL = logbookRef.getString("id_logbook",null)

        Log.d("Detaioiii","respooonn"+IDL.toString())

        val client:Login = Config().getService()
        val call : Call<DetailLogbookResponse> = client.detail_logbook(token ="Bearer "+token,id,IDL)

        call.enqueue(object :Callback<DetailLogbookResponse>{
            override fun onResponse(
                call: Call<DetailLogbookResponse>,
                response: Response<DetailLogbookResponse>
            ) {
                val respon = response.body()
                if(respon!=null){
                    val judul = respon.reportTitle
                    binding.judulcuy.text = judul.toString()
                    val tanggal = respon.logbook?.date
                    binding.tanggalku.text = tanggal.toString()
                    val kegiatan = respon.logbook?.activities
                    binding.kerjaku.text = kegiatan.toString()
                }
            }

            override fun onFailure(call: Call<DetailLogbookResponse>, t: Throwable) {
                Log.d("detail-debug", t.localizedMessage)
            }

        })


        val imageView6 = binding.imageView6
        imageView6.setOnClickListener {
            intent = Intent(applicationContext, EditLogbookActivity::class.java)
            startActivity(intent)
        }

        val Back1 = binding.Back1
        Back1.setOnClickListener {
            intent = Intent(applicationContext, ListLogbookActivity::class.java)
            startActivity(intent)
        }
    }
}