package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class tampilanLaporanAkhirKP : AppCompatActivity() {
    private lateinit var Back4 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tampilan_laporan_akhir_kp)
        supportActionBar?.hide()

        val btn: Button = findViewById(R.id.button_nama1)
        btn.setOnClickListener {
            intent = Intent(this, formLaporanKP::class.java)
            startActivity(intent)
        }
        Back4 = findViewById(R.id.Back4)
        Back4.setOnClickListener {
            intent = Intent(applicationContext, detailKP::class.java)
            startActivity(intent)
        }
    }
}