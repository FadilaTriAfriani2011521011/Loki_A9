package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportActionBar?.hide()


        val btn: Button = findViewById(R.id.button110)
        btn.setOnClickListener {
            intent = Intent(this, edit_profile::class.java)
            startActivity(intent)
        }
    }
}