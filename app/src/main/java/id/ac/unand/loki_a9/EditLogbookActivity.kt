package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class EditLogbookActivity : AppCompatActivity() {
    private lateinit var Back8 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_logbook)
        supportActionBar?.hide()

        val btnLogbook : Button = findViewById (R.id.buttonlog)
        btnLogbook.setOnClickListener {
            intent = Intent(this, LogbookActivity::class.java)
            startActivity(intent)
        }
        Back8 = findViewById(R.id.Back8)
        Back8.setOnClickListener {
            intent = Intent(applicationContext, LogbookActivity::class.java)
            startActivity(intent)
        }
    }
}