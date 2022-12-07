package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.loki_a9.adapter.LogbookAdapter
import id.ac.unand.loki_a9.models.LogbookModels


class ListLogbook : AppCompatActivity() {
    private lateinit var rvlogbook : RecyclerView
    private lateinit var logbookList : ArrayList<LogbookModels>
    private lateinit var adapter: LogbookAdapter
    private lateinit var Back3 : ImageView

    private lateinit var imageView11: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_logbook)
        supportActionBar?.hide()

        rvlogbook = findViewById(R.id.rv_logbook)
        rvlogbook.layoutManager = LinearLayoutManager(this)

        logbookList = ArrayList()

        logbookList.add(LogbookModels("10 Oktober 2022","Gotong Royong"))
        logbookList.add(LogbookModels("11 Oktober 2022","Gotong Royong"))
        logbookList.add(LogbookModels("12 Oktober 2022","Gotong Royong"))
        logbookList.add(LogbookModels("13 Oktober 2022","Input Data"))
        logbookList.add(LogbookModels("14 Oktober 2022","Input Data"))
        logbookList.add(LogbookModels("15 Oktober 2022","Input Data"))
        logbookList.add(LogbookModels("16 Oktober 2022","Gotong Royong"))
        logbookList.add(LogbookModels("17 Oktober 2022","Gotong Royong"))
        logbookList.add(LogbookModels("18 Oktober 2022","Gotong Royong"))

        adapter = LogbookAdapter(logbookList)
        rvlogbook.adapter = adapter

        adapter.setOnItemClickListener(object : LogbookAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
               val intent = Intent(this@ListLogbook, Logbook::class.java)
                intent.putExtra("tanggal",logbookList[position].tanggal)
                intent.putExtra("kegiatan",logbookList[position].kegiatan)
                startActivity(intent)
            }

        })
        Back3 = findViewById(R.id.Back3)
        Back3.setOnClickListener {
            intent = Intent(applicationContext, detailKP::class.java)
            startActivity(intent)
        }

        val btn: Button = findViewById(R.id.buttontbh)
        btn.setOnClickListener {
            intent = Intent(this, TambahLogbook::class.java)
            startActivity(intent)
        }
    }
}
