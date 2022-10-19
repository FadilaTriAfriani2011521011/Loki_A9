package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.loki_a9.adapter.HomeAdapter
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
        data.add(HomeModels(1,"Pengajuan KP", null))
        data.add(HomeModels(1,"Detail KP", null))
        data.add(HomeModels(1,"Informasi Seminar KP", null))

        adapter = HomeAdapter(data)
        adapter.setOnClickListener(object : HomeAdapter.clickListener{
            override fun onItemClick(position: Int) {
//                Toast.makeText(this@MahasiswaKpActivity, "Ini item no ${position + 1}", Toast.LENGTH_SHORT).show()
//                val detailMahasiswa = Intent (this@MahasiswaKpActivity, DetailMahasiswaKpActivity::class.java)
//                startActivity(detailMahasiswa)
            }
        })





}
}