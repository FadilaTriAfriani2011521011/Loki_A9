package id.ac.unand.loki_a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.loki_a9.adapter.Main2Adapter
import id.ac.unand.loki_a9.databinding.ActivityHomescreenBinding
import id.ac.unand.loki_a9.models.MainModels
import kotlinx.android.synthetic.main.rv_main2.*

class HomescreenActivity : AppCompatActivity() {
    private lateinit var imageView4 : ImageView
    private lateinit var rvMain : RecyclerView
    private lateinit var menulist : ArrayList<MainModels>
    private lateinit var adapter: Main2Adapter
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

        rvMain = findViewById(R.id.rv_main)
        rvMain.layoutManager = LinearLayoutManager(this)

        menulist = ArrayList()

        menulist.add(MainModels(R.drawable.pengajuan))
        menulist.add(MainModels(R.drawable.detail))
        menulist.add(MainModels(R.drawable.informasi))

        adapter = Main2Adapter(menulist)
        rvMain.adapter = adapter

        adapter.setOnItemClickListener(object : Main2Adapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@HomescreenActivity, pengajuanKPActivity::class.java)
                intent.putExtra("pengajuan",image_vw)
                startActivity(intent)
            }

        })

        adapter.setOnItemClickListener(object : Main2Adapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@HomescreenActivity, DetailKP2Activity::class.java)
                intent.putExtra("detail",image_vw)
                startActivity(intent)
            }

        })

        adapter.setOnItemClickListener(object : Main2Adapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@HomescreenActivity, seminarKPActivity::class.java)
                intent.putExtra("informasi",image_vw)
                startActivity(intent)
            }

        })


        imageView4 = findViewById(R.id.imageView4)
        imageView4.setOnClickListener{
            intent = Intent(applicationContext, profileActivity::class.java)
            startActivity(intent)
        }


    }
}

private fun Parcelable.putExtra(s: String, imageVw: ImageView?) {

}

private fun Intent.putExtras(pengajuan: Any) {

}

private fun Any.putExtras(pengajuan: Int, imageVw: Int) {

}



