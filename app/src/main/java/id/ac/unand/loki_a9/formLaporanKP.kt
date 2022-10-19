package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class formLaporanKP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_laporan_kp)
        supportActionBar?.hide()


        val btn: Button = findViewById(R.id.buttonsem)
        btn.setOnClickListener {
            intent = Intent(this, tampilanLaporanAkhirKP::class.java)
            startActivity(intent)
        }
    }
}