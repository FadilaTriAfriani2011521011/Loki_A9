package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class tampilanLaporanAkhirKP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tampilan_laporan_akhir_kp)

        val btn: Button = findViewById(R.id.button_nama1)
        btn.setOnClickListener {
            intent = Intent(this, formLaporanKP::class.java)
            startActivity(intent)
        }
    }
}