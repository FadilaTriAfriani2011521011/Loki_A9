package id.ac.unand.loki_a9.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.loki_a9.R
import id.ac.unand.loki_a9.databinding.ItemLogbookBinding
import id.ac.unand.loki_a9.models.LogbookModels
import id.ac.unand.loki_a9.retrofit.LogbooksItem

class LogbookAdapter() :RecyclerView.Adapter<LogbookAdapter.LogBookViewHolder>(){

    private lateinit var logbokLister : onClickListener

    interface onClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnClickListener(listener: onClickListener){
        logbokLister = listener
    }
    var listLogbook : List<LogbooksItem> = ArrayList()

    fun setlistLogbook(listLogbook:List<LogbooksItem>){
        this.listLogbook = listLogbook
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogBookViewHolder {
        return  LogBookViewHolder(ItemLogbookBinding.inflate(LayoutInflater.from(parent.context)
            , parent, false),logbokLister)
    }

    override fun onBindViewHolder(holder: LogBookViewHolder, position: Int) {
        val item : LogbooksItem = listLogbook.get(position)
        holder.itemBinding.kegiatan.text = item.activities
        holder.itemBinding.tanggal.text = item.date
    }
    override fun getItemCount(): Int {
        return listLogbook.size
    }
    inner class LogBookViewHolder(val itemBinding:ItemLogbookBinding,listener: onClickListener):
        RecyclerView.ViewHolder(itemBinding.root) {
        init {
            itemView.setOnClickListener{
                listener.onItemClick(bindingAdapterPosition)
            }
        }
    }
}