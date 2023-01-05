package id.ac.unand.loki_a9.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.loki_a9.R
import id.ac.unand.loki_a9.models.PengajuanModels
import id.ac.unand.loki_a9.retrofit.CompanyItem

class PengajuanAdapter () :

    RecyclerView.Adapter<PengajuanAdapter.pengajuanViewHolder>() {

//    private lateinit var tempatList : ArrayList<PengajuanModels>

    var tempatList : List<CompanyItem> = ArrayList()

    interface clickListener {
        fun onItemClick(position: Int)
    }



    inner class pengajuanViewHolder (itemView: View, listener: clickListener): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): pengajuanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pengajuan, parent, false)
        return  pengajuanViewHolder(view, laporanKpListener)
    }

    override fun onBindViewHolder(holder:  pengajuanViewHolder, position: Int) {
        val item : CompanyItem= tempatList.get(position)
        holder.nama.text = item.name
        holder.nim.text = item.address
    }

    override fun getItemCount(): Int {
        return tempatList.size
    }


    }


