package id.ac.unand.loki_a9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import id.ac.unand.loki_a9.databinding.ActivityMainBinding



class MainFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)
        supportActionBar?.hide()

        val judulAtas : TextView = findViewById(R.id.textView)
        val bundle : Bundle? = intent.extras
        val judul = bundle!!.getString("judul")
        judulAtas.text = judul

//        val idFragment : View? = findViewById(R.id.nah_ini)
//        val id_fragment = bundle!!.getInt("id")
//        if (idFragment != null) {
//            idFragment.layout(findViewById(R.id.nah_ini))
//        }

        lateinit var viewOfLayout: View
        fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            // Inflate the layout for this fragment
            viewOfLayout = inflater!!.inflate(R.layout.activity_main_fragment, container, false)
            return viewOfLayout
        }



//        val btn: Button = findViewById(R.id.buttonsem)
//        btn.setOnClickListener {
//            intent = Intent(this, absenKP::class.java)
//            startActivity(intent)
//        }
    }
}