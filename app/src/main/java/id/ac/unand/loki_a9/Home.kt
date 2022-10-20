package id.ac.unand.loki_a9

import FragmentSeminarKP
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.loki_a9.adapter.HomeAdapter
import id.ac.unand.loki_a9.adapter.LogbookAdapter
import id.ac.unand.loki_a9.models.HomeModels

class Home : AppCompatActivity() {

    lateinit var home_view : RecyclerView
    lateinit var adapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()

        init()

        home_view.layoutManager = LinearLayoutManager(this)
        home_view.adapter = adapter

    }

    private fun init(){
        home_view =findViewById(R.id.home_view)

        val data =ArrayList<HomeModels>()
        data.add(HomeModels(1,"Pengajuan KP", null, 1, ))
        data.add(HomeModels(2,"Detail KP", null, 2))
        data.add(HomeModels(3,"Seminar KP", null, 3))
        data.add(HomeModels(4,"Hal Lainnya", null, 4))
        data.add(HomeModels(5,"Hal Lainnya", null, 5))
        data.add(HomeModels(6,"Hal Lainnya", null ,6))
        data.add(HomeModels(7,"Hal Lainnya", null,7))

        adapter = HomeAdapter(data)
        adapter.setOnClickListener(object : HomeAdapter.clickListener {
            override fun onItemClick(position: Int) {
//                Toast.makeText(this@Home, "Ini item no ${position + 1}", Toast.LENGTH_SHORT).show()
//                val detailMahasiswa = Intent (this@MahasiswaKpActivity, DetailMahasiswaKpActivity::class.java)
//                startActivity(detailMahasiswa)

//                intent = Intent(applicationContext, seminarKP::class.java)
//                startActivity(intent)

//                startActivity(
//                    Intent(applicationContext, seminarKP::class.java)
//                        .putExtra("intent_title", position)
//                )
                    val intent = Intent(this@Home, FragmentSeminarKP::class.java)
                    intent.putExtra("judul", data[position].judul)
                    intent.putExtra("nah_ini", data[position].nah_ini)
                    startActivity(intent)

            }
        })
    }
}

