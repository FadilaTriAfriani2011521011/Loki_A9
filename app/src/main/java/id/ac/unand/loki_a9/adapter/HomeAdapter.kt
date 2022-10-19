package id.ac.unand.loki_a9.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.loki_a9.Home
import id.ac.unand.loki_a9.R
import id.ac.unand.loki_a9.models.HomeModels

class HomeAdapter(private val data:ArrayList<HomeModels>) :
    RecyclerView.Adapter<HomeAdapter.homeViewHolder>() {
    private lateinit var MenuListener : clickListener

    interface clickListener{
        fun onItemClick(position: Int)
    }

    fun setOnClickListener (listener: clickListener) {
        MenuListener = listener
    }

    inner class homeViewHolder(itemView: View, listener: clickListener):RecyclerView.ViewHolder(itemView) {
        private val judul:TextView =itemView.findViewById(R.id.judul)

        fun bind(data: HomeModels){
            judul.text = data.judul
        }

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): homeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.home_view, parent, false)
        return homeViewHolder(itemView, MenuListener)
    }

    override fun onBindViewHolder(holder: homeViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }


    }