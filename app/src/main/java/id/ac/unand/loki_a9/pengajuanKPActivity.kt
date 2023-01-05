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

class pengajuanKPActivity : AppCompatActivity() {
    private lateinit var Back7 : ImageView

    val CHANNEL_ID_pengajuanKP = "channelID_pengajuanKP"
    val CHANNEL_NAME_pengajuanKP = "channelName_pengajuanKP"
    val NOTIFICATION_ID_pengajuanKP = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengajuan_kp)
        supportActionBar?.hide()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel()
        }

        val notification = NotificationCompat.Builder(this, CHANNEL_ID_pengajuanKP)
            .setContentTitle("New Notification")
            .setContentText("Pengajuan KP berhasil dikirim")
            .setSmallIcon(R.drawable.ic_nim)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()
        val notificationManager = NotificationManagerCompat.from(this)
        buttonLogin.setOnClickListener {
            notificationManager.notify(NOTIFICATION_ID_pengajuanKP, notification)
            finish()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID_pengajuanKP, CHANNEL_NAME_pengajuanKP, NotificationManager.IMPORTANCE_DEFAULT).apply {
                lightColor = Color.GREEN
                enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }

        val btn: Button = findViewById(R.id.button7)
        btn.setOnClickListener {
            intent = Intent(this, ListLogbookActivity::class.java)
            startActivity(intent)
        val intent = Intent(this, pengajuanKPActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)

        val btn: Button = findViewById(R.id.button12)
        btn.setOnClickListener {
            val intent = Intent(this, ListPengajuanKPActivity::class.java)
            startActivity(intent)
        }
        Back7 = findViewById(R.id.Back7)
        Back7.setOnClickListener {
            val intent = Intent(applicationContext, ListPengajuanKPActivity::class.java)
            startActivity(intent)
        }
    }
}