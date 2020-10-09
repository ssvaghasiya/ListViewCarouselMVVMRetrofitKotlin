package com.example.listkotlin.ui.gallary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.listkotlin.Model.TempDataModel
import com.example.listkotlin.R
import com.example.listkotlin.ui.family.SurnameAdapter
import kotlinx.android.synthetic.main.gallary_item.view.*
import kotlinx.android.synthetic.main.surname_item.view.*

class GallaryAdapter(private val exapmleList: MutableList<TempDataModel>): RecyclerView.Adapter<GallaryAdapter.GallaryViewHolder>() {
    lateinit var  context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GallaryViewHolder {
        context = parent.context
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.gallary_item,parent,false)
        return GallaryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return exapmleList.size
    }

    override fun onBindViewHolder(holder: GallaryViewHolder, position: Int) {
        var currentItem = exapmleList[position]

        holder.textView1.text = currentItem.text
        holder.imageView.setImageResource(currentItem.imageResources)

        holder.itemView.setOnClickListener {
//            var intent = Intent(context, SampleActivity::class.java)
//            intent.putExtra("user",currentItem.firstName)
//            context.startActivity(intent)
        }
    }

    class GallaryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView1: TextView = itemView.textview_gallary
        val imageView: ImageView = itemView.image_gallary
    }
}