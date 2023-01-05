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

    private lateinit var logbokLister : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnClickListener(listener: onItemClickListener){
        logbokLister = listener
    }
    var listLogbook : List<LogbooksItem> = ArrayList()

    fun setlistLogbook(listLogbook:List<LogbooksItem>){
        this.listLogbook = listLogbook
        notifyDataSetChanged()
    }
    inner class LogBookViewHolder(val itemBindingku:ItemLogbookBinding,listener: onItemClickListener):
        RecyclerView.ViewHolder(itemBindingku.root) {
        init {
            itemView.setOnClickListener{
                listener.onItemClick(bindingAdapterPosition)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogBookViewHolder {
        return  LogBookViewHolder(ItemLogbookBinding.inflate(LayoutInflater.from(parent.context)
            , parent, false),logbokLister)
    }

    override fun onBindViewHolder(holder: LogBookViewHolder, position: Int) {
        val item : LogbooksItem = listLogbook.get(position)
        holder.itemBindingku.kegiatan.text = item.activities
        holder.itemBindingku.tanggal.text = item.date
    }
    override fun getItemCount(): Int {
        return listLogbook.size
    }
}