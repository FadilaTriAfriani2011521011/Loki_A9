package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class TambahLogbookActivity : AppCompatActivity() {
    private lateinit var Back6 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_logbook)
        supportActionBar?.hide()

        val btn: Button = findViewById(R.id.button7)
        btn.setOnClickListener {
            intent = Intent(this, ListLogbookActivity::class.java)
            startActivity(intent)
        }
        Back6 = findViewById(R.id.Back6)
        Back6.setOnClickListener {
            intent = Intent(applicationContext, ListLogbookActivity::class.java)
            startActivity(intent)
        }
    }
}