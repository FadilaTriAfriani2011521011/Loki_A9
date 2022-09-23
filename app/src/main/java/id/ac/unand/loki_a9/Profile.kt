package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val btn: Button = findViewById(R.id.button105)
        btn.setOnClickListener {
            intent = Intent(this, Ubah::class.java)
            startActivity(intent)
        }
    }
}