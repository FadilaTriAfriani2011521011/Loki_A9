package id.ac.unand.loki_a9

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.loki_a9.adapter.LogbookAdapter
import id.ac.unand.loki_a9.databinding.ActivityListLogbookBinding
import id.ac.unand.loki_a9.databinding.ItemLogbookBinding
import id.ac.unand.loki_a9.retrofit.Config
import id.ac.unand.loki_a9.retrofit.ListLogbookResponse
import id.ac.unand.loki_a9.retrofit.LogbooksItem
import id.ac.unand.loki_a9.retrofit.Login
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListLogbookActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: LogbookAdapter
    lateinit var binding:ActivityListLogbookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListLogbookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter : LogbookAdapter = LogbookAdapter()

        val sharedPrefToken = getSharedPreferences("sharedpref",Context.MODE_PRIVATE)?:return
        val token = sharedPrefToken.getString("TOKEN",null)
        val sharedPref = getSharedPreferences("mahapref",Context.MODE_PRIVATE)?:return
        val id = sharedPref.getInt("id",2)

        val data = ArrayList<LogbooksItem>()
        recyclerView = findViewById(R.id.rv_logbook_ku)

        Log.d("list-book-debug",token.toString())
        val client: Login = Config().getService()
        val call: Call<ListLogbookResponse> = client.list_logbook(token = "Bearer " + token, id)

        call.enqueue(object : Callback<ListLogbookResponse>{
            override fun onResponse(
                call: Call<ListLogbookResponse>,
                response: Response<ListLogbookResponse>
            ) {
                val respon = response.body()
                if(respon != null){
                    val list : List<LogbooksItem> = respon.logbooks as List<LogbooksItem>
                    adapter.setlistLogbook(list)
                    Log.d("list-book-debug", list.toString())
                }
                Log.d("list-book-debug", respon?.logbooks?.size.toString())
                Log.d("list-book-debug", "respon : " + respon?.logbooks.toString())

                adapter.setOnClickListener(object : LogbookAdapter.onClickListener{
                    override fun onItemClick(position: Int) {
                        val position = respon?.logbooks?.get(position)
                        val sharedPref = getSharedPreferences("logbookpref", MODE_PRIVATE)?:return
                        with(sharedPref.edit()){
                            putString("id_logbook",position?.id.toString())
                            apply()
                        }
                        Log.d("Detail-logbook",position.toString())
                        val intent = Intent(this@ListLogbookActivity,LogbookActivity::class.java)
//
                        startActivity(intent)
                    }
                })
            }

            override fun onFailure(call: Call<ListLogbookResponse>, t: Throwable) {
                Log.d("list-book-debug", t.localizedMessage)
            }

        })
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val Back3 = binding.Back3
        Back3.setOnClickListener {
            intent = Intent(applicationContext, DetailKP2Activity::class.java)
            startActivity(intent)
        }

        val btn: Button = findViewById(R.id.buttontbh)
        btn.setOnClickListener {
            intent = Intent(this, TambahLogbookActivity::class.java)
            startActivity(intent)
        }
    }
}
