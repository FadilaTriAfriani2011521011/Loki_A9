package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Logbook : AppCompatActivity() {
    private lateinit var imageView6: ImageView
    private lateinit var Back1: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logbook)

        val headingTanggal: TextView = findViewById(R.id.textView12)
        val headingKegiatan: TextView = findViewById(R.id.textView13)

        val bundle: Bundle? = intent.extras
        val tgl = bundle!!.getString("tanggal")
        val act = bundle!!.getString("kegiatan")

        headingTanggal.text = tgl
        headingKegiatan.text = act


        imageView6 = findViewById(R.id.imageView6)
        imageView6.setOnClickListener {
            intent = Intent(applicationContext, EditLogbook::class.java)
            startActivity(intent)
        }

        Back1 = findViewById(R.id.Back1)
        Back1.setOnClickListener {
            intent = Intent(applicationContext, ListLogbook::class.java)
            startActivity(intent)
        }
    }
}