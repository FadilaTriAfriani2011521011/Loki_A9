package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var imageView11 : ImageView
    private lateinit var imageView4 : ImageView
    private lateinit var imageView7 : ImageView
    private lateinit var imageView8 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.hide()

        imageView11 = findViewById(R.id.imageView11)
        imageView11.setOnClickListener{
            intent = Intent(applicationContext, ListPengajuanKP::class.java)
            startActivity(intent)
        }
        imageView4 = findViewById(R.id.imageView4)
        imageView4.setOnClickListener{
            intent = Intent(applicationContext, profile::class.java)
            startActivity(intent)
        }
        imageView7 = findViewById(R.id.imageView7)
        imageView7.setOnClickListener{
            intent = Intent(applicationContext, seminarKP::class.java)
            startActivity(intent)
        }
        imageView8 = findViewById(R.id.imageView8)
        imageView8.setOnClickListener{
            intent = Intent(applicationContext, DetailKP2::class.java)
            startActivity(intent)
        }
    }
}