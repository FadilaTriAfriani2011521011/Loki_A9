package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DetailKP2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kp2)
        supportActionBar?.hide()

        val btnUploadBalasanKP: Button = findViewById(R.id.button88)
        btnUploadBalasanKP.setOnClickListener {
            intent = Intent(this, UploadBalasanKP::class.java)
            startActivity(intent)
        }

        val btnListLogbook: Button = findViewById(R.id.buttonlist)
        btnListLogbook.setOnClickListener {
            intent = Intent(this, ListLogbook::class.java)
            startActivity(intent)
        }

        val btnInputDataSeminarKPSeminarKP: Button = findViewById(R.id.daftar)
        btnInputDataSeminarKPSeminarKP.setOnClickListener {
            intent = Intent(this, InputDataSeminarKP::class.java)
            startActivity(intent)
        }

        val btnTampilanLaporanAkhirKP: Button = findViewById(R.id.buttonlist2)
        btnTampilanLaporanAkhirKP.setOnClickListener {
            intent = Intent(this, tampilanLaporanAkhirKP::class.java)
            startActivity(intent)
        }

    }
}