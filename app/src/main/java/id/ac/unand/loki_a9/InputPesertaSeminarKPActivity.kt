package id.ac.unand.loki_a9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import id.ac.unand.loki_a9.room.peserta
import id.ac.unand.loki_a9.room.pesertaViewModel
import kotlinx.android.synthetic.main.activity_input_peserta_seminar_kp.*
import kotlinx.android.synthetic.main.activity_input_peserta_seminar_kp.view.*

class InputPesertaSeminarKPActivity : AppCompatActivity() {

//    private lateinit var mpesertaViewModel : pesertaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_peserta_seminar_kp)
        supportActionBar?.hide()
//        mpesertaViewModel = ViewModelProvider(this).get(pesertaViewModel::class.java)
////        submit_gue.setOnClickListener {
////            insertDataToDatabase()
////        }

    }

//    fun insertDataToDatabase(){
//
//        val nama = editNamaGue.text.toString()
//        val nim = editNimGue.text.toString()
//
//        if (inputCheck(nama, nim)) {
//            val peserta = peserta(0, nama, nim)
//            mpesertaViewModel.addPeserta(peserta)
//            Toast.makeText(this, "Sukses!", Toast.LENGTH_LONG).show()
//        } else {
//            Toast.makeText(this, "isi cok!", Toast.LENGTH_LONG).show()
//        }
//
//    }
//
//    fun inputCheck(nama: String, nim: String): Boolean {
//        return !(TextUtils.isEmpty(nama) && TextUtils.isEmpty(nim))
//    }
}