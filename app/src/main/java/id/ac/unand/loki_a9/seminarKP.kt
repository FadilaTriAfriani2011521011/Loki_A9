package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class seminarKP : AppCompatActivity() {

//    lateinit var binding : ActivityMainBinding
    lateinit var imageView13 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seminar_kp)
        supportActionBar?.hide()

//        binding = ActivityMainBinding.inflate(layoutInflater)

//        val judulAtas : TextView = findViewById(R.id.textView)
//        val bundle : Bundle? = intent.extras
//        val judul = bundle!!.getString("judul")
//
//        judulAtas.text = judul

        val btn: Button = findViewById(R.id.buttonsem)
        btn.setOnClickListener {
            intent = Intent(this, absenKP::class.java)
            startActivity(intent)
        }

        imageView13 = findViewById(R.id.imageView13)
        imageView13.setOnClickListener{
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

