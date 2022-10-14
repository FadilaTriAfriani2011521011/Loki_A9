package id.ac.unand.loki_a9.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.loki_a9.R
import id.ac.unand.loki_a9.models.PengajuanModels

class PengajuanAdapter (private var tempatList : ArrayList<PengajuanModels>) :

    RecyclerView.Adapter<PengajuanAdapter.pengajuanViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): pengajuanViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_pengajuan, parent, false)
        return pengajuanViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return tempatList.size
    }

    class pengajuanViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tempat: TextView = itemView.findViewById(R.id.tempat)
    }

    override fun onBindViewHolder(holder: pengajuanViewHolder, position: Int) {
        val currentPosition = tempatList[position]
        holder.tempat.setText(currentPosition.tempat)
    }
    }


