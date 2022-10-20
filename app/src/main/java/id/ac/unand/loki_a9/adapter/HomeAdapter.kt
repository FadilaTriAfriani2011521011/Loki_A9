package id.ac.unand.loki_a9.adapter

import FragmentDetailKP
import FragmentPengajuanKP
import FragmentSeminarKP
import android.content.Context
import android.content.Intent
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.loki_a9.HomeFragment
import id.ac.unand.loki_a9.MainFragment
import id.ac.unand.loki_a9.R
import id.ac.unand.loki_a9.models.HomeModels

class HomeAdapter(private val data:ArrayList<HomeModels>) :
    RecyclerView.Adapter<HomeAdapter.homeViewHolder>() {
    private lateinit var MenuListener : clickListener

    private val context: Context? = null

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
        val model : HomeModels = data.get(position)
        val currentPosition = data[position]
        holder.bind(data[position])

        holder.itemView.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                val activity=v!!.context as AppCompatActivity
                val fragment= HomeFragment()
                activity.supportFragmentManager.beginTransaction().replace(R.id.home,fragment).addToBackStack(null).commit()
            }
        })

//        fun onClick(v: View?) {
//            val intent: Intent
//            val activity=v!!.context as AppCompatActivity
//            when (position) {
//                0 -> intent = Intent(context, FragmentPengajuanKP::class.java)
//                1 -> intent = Intent(context, FragmentDetailKP::class.java)
//                else -> intent = Intent(context, FragmentSeminarKP::class.java)
//            }
//           context?.startActivity(intent)
//
//
//
//
//
//
//    }



    }

    override fun getItemCount(): Int {
        return data.size
    }

}