package id.ac.unand.loki_a9

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import android.app.TaskStackBuilder
import kotlinx.android.synthetic.main.activity_upload_balasan_kp.*
import androidx.annotation.RequiresApi

class UploadBalasanKPActivity : AppCompatActivity() {
    private lateinit var Back2 : ImageView

    val CHANNEL_ID_UploadBalasanKP = "channelID_UploadBalasanKP"
    val CHANNEL_NAME_UploadBalasanKP = "channelName_UploadBalasanKP"
    val NOTIFICATION_ID_UploadBalasanKP = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_balasan_kp)
        supportActionBar?.hide()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel()
        }
        val intent = Intent(this, DetailKP2Activity::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        val notification = NotificationCompat.Builder(this, CHANNEL_ID_UploadBalasanKP)
            .setContentTitle("New Notification")
            .setContentText("Berhasil Upload Balasan KP")
            .setSmallIcon(R.drawable.ic_nim)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()
        val notificationManager = NotificationManagerCompat.from(this)
        buttonLogin.setOnClickListener {
            notificationManager.notify(NOTIFICATION_ID_UploadBalasanKP, notification)
            finish()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID_UploadBalasanKP, CHANNEL_NAME_UploadBalasanKP, NotificationManager.IMPORTANCE_DEFAULT).apply {
                lightColor = Color.GREEN
                enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }

        val btn: Button = findViewById(R.id.buttonLogin)
        btn.setOnClickListener {
            //intent = Intent(this, detailKP::class.java)
            //startActivity(intent)
            //sendNotification()
        }
        Back2 = findViewById(R.id.Back2)
        Back2.setOnClickListener {
           intent = Intent(applicationContext, detailKPActivity::class.java)
            startActivity(intent)

        }
    }
}