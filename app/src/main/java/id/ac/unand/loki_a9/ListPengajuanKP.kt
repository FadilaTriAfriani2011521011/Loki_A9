package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.loki_a9.adapter.LogbookAdapter
import id.ac.unand.loki_a9.adapter.PengajuanAdapter
import id.ac.unand.loki_a9.models.LogbookModels
import id.ac.unand.loki_a9.models.PengajuanModels

class ListPengajuanKP : AppCompatActivity() {

    private lateinit var rvpengajuan : RecyclerView
    private lateinit var tempatList : ArrayList<PengajuanModels>
    private lateinit var adapter: PengajuanAdapter
    private lateinit var imageView13 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_pengajuan_kp)
        supportActionBar?.hide()


        rvpengajuan = findViewById(R.id.rv_pengajuan)
        rvpengajuan.layoutManager = LinearLayoutManager(this)

        tempatList = ArrayList()

        tempatList.add(PengajuanModels("LLDIKTI"))
        tempatList.add(PengajuanModels("BPS"))
        tempatList.add(PengajuanModels("Semen Padang"))
        tempatList.add(PengajuanModels("BKKBN"))


       adapter = PengajuanAdapter(tempatList)
        rvpengajuan.adapter = adapter

        val btn: Button = findViewById(R.id.button3000)
        btn.setOnClickListener {
            intent = Intent(this, pengajuanKP::class.java)
            startActivity(intent)
        }
    }
}