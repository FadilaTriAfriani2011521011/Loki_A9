package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView


class ListLogbook : AppCompatActivity() {
    private lateinit var imageView11: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_logbook)

        val btn: Button = findViewById(R.id.button5)
        btn.setOnClickListener {
            intent = Intent(this, Logbook::class.java)
            startActivity(intent)

            imageView11 = findViewById(R.id.imageView11)
            imageView11.setOnClickListener {
                intent = Intent(applicationContext, TambahLogbook::class.java)
                startActivity(intent)

            }
        }
    }
}
