package com.example.listkotlin.ui.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.listkotlin.Model.DataGridHome
import com.example.listkotlin.R
import com.example.listkotlin.ui.ads.AdsActivity
import com.example.listkotlin.ui.family.FamilyActivity
import com.example.listkotlin.ui.gallary.GallaryActivity
import com.example.listkotlin.ui.impcontact.ImpContactsActivity
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
            var intent: Intent
            when(position){
                0 -> intent = Intent(context, GallaryActivity::class.java)
                1 -> intent = Intent(context, FamilyActivity::class.java)
                2 -> intent = Intent(context,AdsActivity::class.java)
                else -> intent = Intent(context, ImpContactsActivity::class.java)
            }
            context.startActivity(intent)
        }
    }

    class GridDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imageview: ImageView = itemView.image_gird
        val textView1: TextView = itemView.text_grid
    }
}