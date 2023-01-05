package id.ac.unand.loki_a9

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.loki_a9.adapter.PengajuanAdapter
import id.ac.unand.loki_a9.models.PengajuanModels

class ListPengajuanKPActivity : AppCompatActivity() {

    private lateinit var rvpengajuan: RecyclerView
    private lateinit var tempatList: ArrayList<PengajuanModels>
    private lateinit var adapter: PengajuanAdapter
    private lateinit var Home3: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_pengajuan_kp)
        supportActionBar?.hide()


        rvpengajuan = findViewById(R.id.rv_pengajuan)
        rvpengajuan.layoutManager = LinearLayoutManager(this)

        tempatList = ArrayList()

        tempatList.add(
            PengajuanModels(
                "LLDIKTI",
                R.drawable.lldikti,
                "Jl. Khatib Sulaiman Gunung Pangilun, Alai Parak Kopi, Kec. Padang Utara, Kota Padang, Sumatera Barat 25173"
            )
        )
        tempatList.add(
            PengajuanModels(
                "BPS",
                R.drawable.bps,
                "Jl. Raya By Pass Km.13, Kel.Sungai Sapih, Kuranji, Sungai Sapih, Kec. Kuranji, Kota Padang, Sumatera Barat 25159"
            )
        )
        tempatList.add(
            PengajuanModels(
                "Semen Padang",
                R.drawable.semen_padang,
                "Plaza Lantai 2, Kelurahan Indarung, Indarung, Kec. Lubuk Kilangan, Kota Padang, Sumatera Barat 25157"
            )
        )
        tempatList.add(
            PengajuanModels(
                "BKKBN",
                R.drawable.bkkbn,
                "Ulak Karang Utara, Kec. Padang Utara, Kota Padang, Sumatera Barat"
            )
        )


        adapter = PengajuanAdapter(tempatList)
        rvpengajuan.adapter = adapter

        Home3 = findViewById(R.id.Home3)
        Home3.setOnClickListener {
            intent = Intent(applicationContext, homescreenActivity::class.java)
            startActivity(intent)
        }


    }
}