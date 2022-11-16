package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class profile : AppCompatActivity() {
    private lateinit var Home2 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportActionBar?.hide()

        val btn: Button = findViewById(R.id.button110)
        btn.setOnClickListener {
            intent = Intent(this, edit_profile::class.java)
            startActivity(intent)
        }
        Home2 = findViewById(R.id.Home2)
        Home2.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}