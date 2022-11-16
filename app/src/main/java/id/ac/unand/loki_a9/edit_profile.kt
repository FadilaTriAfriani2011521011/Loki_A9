package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class edit_profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        supportActionBar?.hide()

        val btnganti_pass: Button = findViewById(R.id.button4)
        btnganti_pass.setOnClickListener {
            intent = Intent(this, ganti_pass::class.java)
            startActivity(intent)
        }
        val btnprofile: Button = findViewById(R.id.button1000)
        btnprofile.setOnClickListener {
            intent = Intent(this, profile::class.java)
            startActivity(intent)
        }
    }
}