package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class homescreenActivity : AppCompatActivity() {
    private lateinit var imageView11 : ImageView
    private lateinit var imageView4 : ImageView
    private lateinit var imageView7 : ImageView
    private lateinit var imageView8 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homescreen)
        supportActionBar?.hide()
//button
        imageView11 = findViewById(R.id.imageView11)
        imageView11.setOnClickListener{
            intent = Intent(applicationContext, ListPengajuanKPActivity::class.java)
            startActivity(intent)
        }
        imageView4 = findViewById(R.id.imageView4)
        imageView4.setOnClickListener{
            intent = Intent(applicationContext, profileActivity::class.java)
            startActivity(intent)
        }

        imageView8 = findViewById(R.id.imageView8)
        imageView8.setOnClickListener{
            intent = Intent(applicationContext, DetailKP2Activity::class.java)
            startActivity(intent)
        }
    }
}