package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class detailKP : AppCompatActivity() {
    private lateinit var imageView13 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kp)
        supportActionBar?.hide()


        val btnTampilanLaporanAkhirKP: Button = findViewById(R.id.button11)
        btnTampilanLaporanAkhirKP.setOnClickListener {
            intent = Intent(this, tampilanLaporanAkhirKP::class.java)
            startActivity(intent)
        }

        val btnListLogbook: Button = findViewById(R.id.button9)
        btnListLogbook.setOnClickListener {
            intent = Intent(this, ListLogbook::class.java)
            startActivity(intent)
        }

        val btnUploadBalasanKP: Button = findViewById(R.id.button8)
        btnUploadBalasanKP.setOnClickListener {
            intent = Intent(this, UploadBalasanKP::class.java)
            startActivity(intent)
        }

        imageView13 = findViewById(R.id.imageView13)
        imageView13.setOnClickListener{
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }


        val btnInputDataSeminarKPSeminarKP: Button = findViewById(R.id.button10)
        btnInputDataSeminarKPSeminarKP.setOnClickListener {
            intent = Intent(this, InputDataSeminarKP::class.java)
            startActivity(intent)
        }
    }
}
