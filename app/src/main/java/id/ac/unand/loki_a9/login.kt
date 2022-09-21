package id.ac.unand.loki_a9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button2)
        rollButton.setOnClickListener {
            Toast.makeText(this, "Login Berhasil, Selamat Datang", Toast.LENGTH_SHORT).show()
            val resultTextView: TextView = findViewById(R.id.textView3)
//            resultTextView.text = "Login Berhasil"
        }
    }
}