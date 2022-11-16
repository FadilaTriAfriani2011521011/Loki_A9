package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class InputDataSeminarKP : AppCompatActivity() {
    private lateinit var imageView22 : ImageView
    private lateinit var Back5 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_data_seminar_kp)
        supportActionBar?.hide()
        imageView22 = findViewById(R.id.imageView22)
        imageView22.setOnClickListener{
            intent = Intent(applicationContext, InputPesertaSeminarKP::class.java)
            startActivity(intent)
        }
        Back5 = findViewById(R.id.Back5)
        Back5.setOnClickListener {
            intent = Intent(applicationContext, detailKP::class.java)
            startActivity(intent)
        }
    }
}