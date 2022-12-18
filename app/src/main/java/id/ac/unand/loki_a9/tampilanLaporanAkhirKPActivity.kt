package id.ac.unand.loki_a9

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_tampilan_laporan_akhir_kp.*



class tampilanLaporanAkhirKPActivity : AppCompatActivity() {
    private lateinit var Back4: ImageView

    val CHANNEL_ID_tampilanLaporanAkhirKP = "channelID_tampilanLaporanAkhirKP"
    val CHANNEL_NAME_tampilanLaporanAkhirKP = "channelName_tampilanLaporanAkhirKP"
    val NOTIFICATION_ID_tampilanLaporanAkhirKP = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tampilan_laporan_akhir_kp)
        supportActionBar?.hide()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel()
        }
        val intent = Intent(this, tampilanLaporanAkhirKPActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        val notification = NotificationCompat.Builder(this, CHANNEL_ID_tampilanLaporanAkhirKP)
            .setContentTitle("New Notification")
            .setContentText("Selamat, Laporan Kamu Sudah Selesai")
            .setSmallIcon(R.drawable.ic_nim)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()
        val notificationManager = NotificationManagerCompat.from(this)
        button_nama.setOnClickListener {
            notificationManager.notify(NOTIFICATION_ID_tampilanLaporanAkhirKP, notification)
            finish()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID_tampilanLaporanAkhirKP,
                CHANNEL_NAME_tampilanLaporanAkhirKP,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                lightColor = Color.GREEN
                enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }

            val btn: Button = findViewById(R.id.button_nama)
            btn.setOnClickListener {
//               intent = Intent(this, formLaporanKPActivity::class.java)
//               startActivity(intent)
            }
            Back4 = findViewById(R.id.Back4)
            Back4.setOnClickListener {
                intent = Intent(applicationContext, DetailKP2Activity::class.java)
                startActivity(intent)
            }
        }
    }
