package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class InputPesertaSeminarKP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_peserta_seminar_kp)

        val btn: Button = findViewById(R.id.button60)
        btn.setOnClickListener {
            intent = Intent(this, detailKP::class.java)
            startActivity(intent)
        }
    }
}