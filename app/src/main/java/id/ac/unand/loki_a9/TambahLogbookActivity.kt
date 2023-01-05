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
import kotlinx.android.synthetic.main.activity_upload_balasan_kp.*

class TambahLogbookActivity : AppCompatActivity() {
    private lateinit var Back6 : ImageView

    val CHANNEL_ID_TambahLogbook = "channelID_TambahLogbook"
    val CHANNEL_NAME_TambahLogbook = "channelName_TambahLogbook"
    val NOTIFICATION_ID_TambahLogbook= 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_logbook)
        supportActionBar?.hide()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel()
        }
        val intent = Intent(this, DetailKP2Activity::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        val notification = NotificationCompat.Builder(this, CHANNEL_ID_TambahLogbook)
            .setContentTitle("New Notification")
            .setContentText("Berhasil menambah logbook")
            .setSmallIcon(R.drawable.ic_nim)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()
        val notificationManager = NotificationManagerCompat.from(this)
        buttonLogin.setOnClickListener {
            notificationManager.notify(NOTIFICATION_ID_TambahLogbook, notification)
            finish()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID_TambahLogbook, CHANNEL_NAME_TambahLogbook, NotificationManager.IMPORTANCE_DEFAULT).apply {
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
        }
        Back6 = findViewById(R.id.Back6)
        Back6.setOnClickListener {
            intent = Intent(applicationContext, ListLogbookActivity::class.java)
            startActivity(intent)
        }


  }

}