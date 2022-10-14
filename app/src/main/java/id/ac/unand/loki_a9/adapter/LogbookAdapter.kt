package id.ac.unand.loki_a9.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.loki_a9.R
import id.ac.unand.loki_a9.models.LogbookModels

class LogbookAdapter(private val logbookList : ArrayList<LogbookModels>) :
    RecyclerView.Adapter<LogbookAdapter.logbookViewHolder>() {

    private lateinit var myListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        myListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): logbookViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_logbook, parent, false)
        return logbookViewHolder(itemView, myListener)
    }

    override fun onBindViewHolder(holder: logbookViewHolder, position: Int) {
       val currentPosition = logbookList[position]
        holder.tanggal.setText(currentPosition.tanggal)
        holder.kegiatan.setText(currentPosition.kegiatan)
    }

    override fun getItemCount(): Int {
        return logbookList.size
    }

    class logbookViewHolder (itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val tanggal : TextView = itemView.findViewById(R.id.tanggal)
        val kegiatan : TextView = itemView.findViewById(R.id.kegiatan)

        init{
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }

    }
}