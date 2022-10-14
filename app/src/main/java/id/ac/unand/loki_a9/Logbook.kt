package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Logbook : AppCompatActivity() {
    private lateinit var imageView6: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logbook)

        imageView6 = findViewById(R.id.imageView6)
        imageView6.setOnClickListener {
            intent = Intent(applicationContext, EditLogbook::class.java)
            startActivity(intent)
        }
    }
}