package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class detailKPActivity : AppCompatActivity() {
    private lateinit var Home1 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kp)
        supportActionBar?.hide()

        val btnTampilanLaporanAkhirKP: Button = findViewById(R.id.button11)
        btnTampilanLaporanAkhirKP.setOnClickListener {
            intent = Intent(this, tampilanLaporanAkhirKPActivity::class.java)
            startActivity(intent)
        }

        val btnListLogbook: Button = findViewById(R.id.button9)
        btnListLogbook.setOnClickListener {
            intent = Intent(this, ListLogbookActivity::class.java)
            startActivity(intent)
        }

        val btnInputDataSeminarKPSeminarKP: Button = findViewById(R.id.button10)
        btnInputDataSeminarKPSeminarKP.setOnClickListener {
            intent = Intent(this, InputDataSeminarKPActivity::class.java)
            startActivity(intent)
        }

        val btnUploadBalasanKP: Button = findViewById(R.id.button88)
        btnUploadBalasanKP.setOnClickListener {
            intent = Intent(this, UploadBalasanKPActivity::class.java)
            startActivity(intent)
        }
        Home1 = findViewById(R.id.Home1)
        Home1.setOnClickListener {
            intent = Intent(applicationContext, HomescreenActivity::class.java)
            startActivity(intent)
        }
    }
}
