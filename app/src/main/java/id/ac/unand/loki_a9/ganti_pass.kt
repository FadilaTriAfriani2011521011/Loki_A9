package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ganti_pass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ganti_pass)

        val btn: Button = findViewById(R.id.button7)
        btn.setOnClickListener {
            intent = Intent(this, Ubah::class.java)
            startActivity(intent)
    }
}}