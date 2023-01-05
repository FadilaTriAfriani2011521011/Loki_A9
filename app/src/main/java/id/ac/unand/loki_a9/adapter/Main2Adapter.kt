package id.ac.unand.loki_a9.adapter

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.loki_a9.R
import id.ac.unand.loki_a9.models.MainModels

class Main2Adapter (private val menulist : ArrayList<MainModels>) :
    RecyclerView.Adapter<Main2Adapter.mainViewHolder>() {

    private lateinit var myListener: onItemClickListener
    var onItemClick : ((MainModels) -> Unit)? = null
    private fun Parcelable.putExtras(pengajuan: Int, imageVw: Int) {

    }

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        myListener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mainViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_main2, parent, false)
        return mainViewHolder(itemView, myListener)
    }

    override fun onBindViewHolder(holder: mainViewHolder, position: Int) {
        val currentPosition = menulist[position]
        holder.image_vw.setImageResource(currentPosition.image_vw)
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(currentPosition)
        }
    }

    override fun getItemCount(): Int {
        return menulist.size
    }

    class mainViewHolder (itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val image_vw : ImageView = itemView.findViewById(R.id.image_vw)

        init{
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }

    }

}


