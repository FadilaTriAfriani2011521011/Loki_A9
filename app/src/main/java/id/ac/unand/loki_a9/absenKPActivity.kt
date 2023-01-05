package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class absenKPActivity : AppCompatActivity() {
    private lateinit var imageView : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_absen_kp)
        supportActionBar?.hide()

        imageView = findViewById(R.id.imageView)
        imageView.setOnClickListener{
            intent = Intent(applicationContext, AbsenSeminarActivity::class.java)
            startActivity(intent)
        }
    }
}