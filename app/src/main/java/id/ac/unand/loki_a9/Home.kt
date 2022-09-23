package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btn: Button = findViewById(R.id.button30)
        btn.setOnClickListener {
            intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}