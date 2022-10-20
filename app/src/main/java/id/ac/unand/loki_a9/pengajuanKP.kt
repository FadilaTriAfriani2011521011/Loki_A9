package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class pengajuanKP : AppCompatActivity() {
    private lateinit var Back7 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengajuan_kp)

        val btn: Button = findViewById(R.id.button12)
        btn.setOnClickListener {
            intent = Intent(this, ListPengajuanKP::class.java)
            startActivity(intent)
        }
        Back7 = findViewById(R.id.Back7)
        Back7.setOnClickListener {
            intent = Intent(applicationContext, ListPengajuanKP::class.java)
            startActivity(intent)
        }
    }
}