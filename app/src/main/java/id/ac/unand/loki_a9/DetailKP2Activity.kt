package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DetailKP2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kp2)
        supportActionBar?.hide()

        val btnUploadBalasanKP: Button = findViewById(R.id.button88)
        btnUploadBalasanKP.setOnClickListener {
            intent = Intent(this, UploadBalasanKPActivity::class.java)
            startActivity(intent)
        }

        val btnListLogbook: Button = findViewById(R.id.buttonlist)
        btnListLogbook.setOnClickListener {
            intent = Intent(this, ListLogbookActivity::class.java)
            startActivity(intent)
        }

    }
}