package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class pengajuanKP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengajuan_kp)
        supportActionBar?.hide()


        val btn: Button = findViewById(R.id.button12)
        btn.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}