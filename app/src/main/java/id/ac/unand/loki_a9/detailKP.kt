package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class detailKP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kp)

        val btn: Button = findViewById(R.id.button11)
        btn.setOnClickListener {
            intent = Intent(this, tampilanLaporanAkhirKP::class.java)
            startActivity(intent)

        val btn: Button = findViewById(R.id.button9)
        btn.setOnClickListener {
            intent = Intent(this, ListLogbook::class.java)
            startActivity(intent)

        val btn: Button = findViewById(R.id.button8)
        btn.setOnClickListener {
            intent = Intent(this, UploadBalasanKP::class.java)
            startActivity(intent)


            val btn: Button = findViewById(R.id.button10)
            btn.setOnClickListener {
                intent = Intent(this, InputDataSeminarKP::class.java)
                startActivity(intent)

                    }
                }
            }
        }
    }
}