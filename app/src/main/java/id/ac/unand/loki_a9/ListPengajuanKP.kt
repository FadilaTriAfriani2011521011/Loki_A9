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
import id.ac.unand.loki_a9.adapter.LogbookAdapter
import id.ac.unand.loki_a9.adapter.PengajuanAdapter
import id.ac.unand.loki_a9.models.LogbookModels
import id.ac.unand.loki_a9.models.PengajuanModels

class ListPengajuanKP : AppCompatActivity() {

    private lateinit var rvpengajuan : RecyclerView
    private lateinit var tempatList : ArrayList<PengajuanModels>
    private lateinit var adapter: PengajuanAdapter
    private lateinit var Home3 : ImageView
    private val CHANNEL_ID = "informasi"
    private val notificationId = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_pengajuan_kp)
        supportActionBar?.hide()
        createNotificationChannel()


        rvpengajuan = findViewById(R.id.rv_pengajuan)
        rvpengajuan.layoutManager = LinearLayoutManager(this)

        tempatList = ArrayList()

        tempatList.add(PengajuanModels("LLDIKTI", R.drawable.lldikti, "Jl. Khatib Sulaiman Gunung Pangilun, Alai Parak Kopi, Kec. Padang Utara, Kota Padang, Sumatera Barat 25173"))
        tempatList.add(PengajuanModels("BPS", R.drawable.bps, "Jl. Raya By Pass Km.13, Kel.Sungai Sapih, Kuranji, Sungai Sapih, Kec. Kuranji, Kota Padang, Sumatera Barat 25159"))
        tempatList.add(PengajuanModels("Semen Padang", R.drawable.semen_padang, "Plaza Lantai 2, Kelurahan Indarung, Indarung, Kec. Lubuk Kilangan, Kota Padang, Sumatera Barat 25157"))
        tempatList.add(PengajuanModels("BKKBN", R.drawable.bkkbn, "Ulak Karang Utara, Kec. Padang Utara, Kota Padang, Sumatera Barat"))


       adapter = PengajuanAdapter(tempatList)
        rvpengajuan.adapter = adapter



        val btn: Button = findViewById(R.id.button3000)
        btn.setOnClickListener {
//            intent = Intent(this, pengajuanKP::class.java)
//            startActivity(intent)
            sendNotification()

        }
        Home3 = findViewById(R.id.Home3)
        Home3.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }


    }

    private fun sendNotification() {
        var builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.bps)
            .setContentTitle("Anda Sudah Mendaftar!!")
            .setContentText("Keren, mari mulai petualangan Kerja Pratek Anda!")
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(notificationId, builder.build())
        }
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "nama channel"
            val descriptionText = "deskripsi channel"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

    }
}