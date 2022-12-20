package id.ac.unand.loki_a9

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class profileActivity : AppCompatActivity() {
    private lateinit var Home2 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportActionBar?.hide()

        val btnLogout: Button = findViewById(R.id.logout)
        btnLogout.setOnClickListener{
            val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE)
            with (sharedPref.edit()) {
                putString("token", null)
                apply()
            }

            intent = Intent(applicationContext, loginActivity::class.java)
            startActivity(intent)
            finish()
        }

        val sharedPref = getSharedPreferences("prefs",Context.MODE_PRIVATE) ?: return
        val ada = sharedPref.getString("token",null)

        if (ada==null){
            intent = Intent(applicationContext, loginActivity::class.java)
            startActivity(intent)
            finish()
        }

        val btn: Button = findViewById(R.id.button110)
        btn.setOnClickListener {
            intent = Intent(this, edit_profileActivity::class.java)
            startActivity(intent)
        }
        Home2 = findViewById(R.id.Home2)
        Home2.setOnClickListener {
            intent = Intent(applicationContext, homescreenActivity::class.java)
            startActivity(intent)
        }
    }
}