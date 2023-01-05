package id.ac.unand.loki_a9

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.loki_a9.adapter.AbsenAdapter
import id.ac.unand.loki_a9.models.AbsenModels
import kotlinx.android.synthetic.main.activity_absen_kp.*

class AbsenSeminarActivity : AppCompatActivity() {
    private lateinit var rvabsen : RecyclerView
    private lateinit var absenList : ArrayList<AbsenModels>
    private lateinit var adapter: AbsenAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_absen_seminar)
        supportActionBar?.hide()

        rvabsen = findViewById(R.id.rv_absen)
        rvabsen.layoutManager = LinearLayoutManager(this)

        absenList = ArrayList()

        absenList.add(AbsenModels("Nathania","2011523009", "10 Oktober 2022", "08.00"))
        absenList.add(AbsenModels("Nathan","2011523009", "10 Oktober 2022", "08.02"))
        absenList.add(AbsenModels("Nath","2011523009", "10 Oktober 2022", "08.15"))
        absenList.add(AbsenModels("Thania","2011523009", "10 Oktober 2022", "08.18"))
        absenList.add(AbsenModels("Rahayu","2011523009", "10 Oktober 2022", "08.20"))
        absenList.add(AbsenModels("Ayu","2011523009", "10 Oktober 2022", "08.30"))

        adapter = AbsenAdapter(absenList)
        rvabsen.adapter = adapter

        adapter.setOnItemClickListener(object : AbsenAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@AbsenSeminarActivity, AbsenKP::class.java)
                intent.putExtra("nama", absenList[position].nama)
                intent.putExtra("nim", absenList[position].nim)
                intent.putExtra("tanggal", absenList[position].tanggal)
                intent.putExtra("jam", absenList[position].jam)
                startActivity(intent)
            }

        })
    }

    fun setOnClickListener(view: View) {
        val intent = Intent(this@AbsenSeminarActivity, seminarKPActivity::class.java)
        startActivity(intent)
    }
}