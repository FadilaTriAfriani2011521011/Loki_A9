package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class seminarKPActivity : AppCompatActivity() {
    private lateinit var Home4 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seminar_kp)
        supportActionBar?.hide()

        val btn: Button = findViewById(R.id.buttonsem)
        btn.setOnClickListener {
            intent = Intent(this, absenKPActivity::class.java)
            startActivity(intent)
        }
        Home4 = findViewById(R.id.Home4)
        Home4.setOnClickListener {
            intent = Intent(applicationContext, homescreenActivity::class.java)
            startActivity(intent)
        }
    }
}