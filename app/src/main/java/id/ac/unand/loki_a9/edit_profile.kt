package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class edit_profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val btn: Button = findViewById(R.id.button4)
        btn.setOnClickListener {
            intent = Intent(this, ganti_pass::class.java)
            startActivity(intent)

            val btn: Button = findViewById(R.id.button5)
            btn.setOnClickListener {
                intent = Intent(this, profile::class.java)
                startActivity(intent)
            }
        }
    }
}