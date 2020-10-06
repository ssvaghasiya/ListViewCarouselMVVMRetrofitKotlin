package com.example.listkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_grid_home.view.*


class GridDataAdapter(private val exapmleList: MutableList<DataGridHome>): RecyclerView.Adapter<GridDataAdapter.GridDataViewHolder>() {
    lateinit var  context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridDataViewHolder {
        context = parent.context
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_home,parent,false)
        return GridDataViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return exapmleList.size
    }

    override fun onBindViewHolder(holder: GridDataViewHolder, position: Int) {
        var currentItem = exapmleList[position]

        holder.imageview.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1

        holder.itemView.setOnClickListener {
//            var intent = Intent(context, SampleActivity::class.java)
//            intent.putExtra("user",currentItem.firstName)
//            context.startActivity(intent)
            Toast.makeText(context,"Item $position", Toast.LENGTH_SHORT).show()
        }
    }

    class GridDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imageview: ImageView = itemView.image_gird
        val textView1: TextView = itemView.text_grid
    }
}