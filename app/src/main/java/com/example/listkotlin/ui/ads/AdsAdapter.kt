package com.example.listkotlin.ui.ads

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.listkotlin.Model.TempDataModel
import com.example.listkotlin.R
import kotlinx.android.synthetic.main.ads_item.view.*

class AdsAdapter(private val exapmleList: MutableList<TempDataModel>): RecyclerView.Adapter<AdsAdapter.AdsViewHolder>() {
    lateinit var  context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdsViewHolder {
        context = parent.context
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.ads_item,parent,false)
        return AdsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return exapmleList.size
    }

    override fun onBindViewHolder(holder: AdsViewHolder, position: Int) {
        var currentItem = exapmleList[position]

        holder.imageView.setImageResource(currentItem.imageResources)
        holder.itemView.setOnClickListener {
//            var intent = Intent(context, SampleActivity::class.java)
//            intent.putExtra("user",currentItem.firstName)
//            context.startActivity(intent)
        }
    }

    class AdsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.image_ads
    }
}