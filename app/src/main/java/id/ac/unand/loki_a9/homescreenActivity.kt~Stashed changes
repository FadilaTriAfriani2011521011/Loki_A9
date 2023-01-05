package id.ac.unand.loki_a9

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import id.ac.unand.loki_a9.databinding.ActivityHomescreenBinding

class homescreenActivity : AppCompatActivity() {
    private lateinit var imageView11 : ImageView
    private lateinit var imageView4 : ImageView
    private lateinit var imageView7 : ImageView
    private lateinit var imageView8 : ImageView
    lateinit var binding: ActivityHomescreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomescreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val sharedPref = getSharedPreferences("sharedpref", MODE_PRIVATE) ?: return
        val token = sharedPref.getString("token",null)
        val namaUser = sharedPref.getString("name",null)

        if (token==null){
            intent = Intent(applicationContext, loginActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.kembali.text = namaUser

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
        imageView7 = findViewById(R.id.imageView7)
        imageView7.setOnClickListener{
            intent = Intent(applicationContext, seminarKPActivity::class.java)
            startActivity(intent)
        }
        imageView8 = findViewById(R.id.imageView8)
        imageView8.setOnClickListener{
            intent = Intent(applicationContext, DetailKP2Activity::class.java)
            startActivity(intent)
        }
    }
}
