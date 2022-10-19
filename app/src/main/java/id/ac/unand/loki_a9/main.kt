package id.ac.unand.loki_a9

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

                Handler().postDelayed({
                    startActivity(Intent(this, login::class.java))
                    finish()
                },3000)

            }

    }
