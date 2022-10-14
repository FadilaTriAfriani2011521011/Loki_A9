package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class InputDataSeminarKP : AppCompatActivity() {
    private lateinit var imageView22 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_data_seminar_kp)
        imageView22 = findViewById(R.id.imageView22)
        imageView22.setOnClickListener{
            intent = Intent(applicationContext, InputPesertaSeminarKP::class.java)
            startActivity(intent)


        }
    }
}