package id.ac.unand.loki_a9.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.loki_a9.R
import id.ac.unand.loki_a9.models.AbsenModels

class AbsenAdapter(private val absenList : ArrayList<AbsenModels>) :
    RecyclerView.Adapter<AbsenAdapter.absenViewHolder>() {

    private lateinit var myListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        myListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): absenViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_absen, parent, false)
        return absenViewHolder(itemView, myListener)
    }

    override fun onBindViewHolder(holder: absenViewHolder, position: Int) {
        val currentPosition = absenList[position]
        holder.nama.setText(currentPosition.nama)
        holder.nim.setText(currentPosition.nim)
        holder.tanggal.setText(currentPosition.tanggal)
        holder.jam.setText(currentPosition.jam)
    }

    override fun getItemCount(): Int {
        return absenList.size
    }

    class absenViewHolder (itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val nama : TextView = itemView.findViewById(R.id.nama)
        val nim : TextView = itemView.findViewById(R.id.nim)
        val tanggal : TextView = itemView.findViewById(R.id.tanggal)
        val jam : TextView = itemView.findViewById(R.id.jam)

        init{
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }

    }
}