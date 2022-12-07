package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class UploadBalasanKP : AppCompatActivity() {
    private lateinit var Back2 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_balasan_kp)
        supportActionBar?.hide()

        val btn: Button = findViewById(R.id.button2)
        btn.setOnClickListener {
            intent = Intent(this, detailKP::class.java)
            startActivity(intent)
        }
        Back2 = findViewById(R.id.Back2)
        Back2.setOnClickListener {
            intent = Intent(applicationContext, detailKP::class.java)
            startActivity(intent)
        }
    }
}