package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UploadBalasanKP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_balasan_kp)
        supportActionBar?.hide()


        val btn: Button = findViewById(R.id.button2)
        btn.setOnClickListener {
            intent = Intent(this, detailKP::class.java)
            startActivity(intent)
        }
    }
}