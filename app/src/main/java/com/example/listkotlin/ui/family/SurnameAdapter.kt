package com.example.listkotlin.ui.family

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.listkotlin.Model.TempDataModel
import com.example.listkotlin.R
import kotlinx.android.synthetic.main.surname_item.view.*

class SurnameAdapter(private val exapmleList: MutableList<TempDataModel>): RecyclerView.Adapter<SurnameAdapter.SurNameViewHolder>() {
    lateinit var  context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurNameViewHolder {
        context = parent.context
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.surname_item,parent,false)
        return SurNameViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return exapmleList.size
    }

    override fun onBindViewHolder(holder: SurNameViewHolder, position: Int) {
        var currentItem = exapmleList[position]

        holder.textView1.text = currentItem.text
        if(position%2 == 0){
//            holder.cardView.background =
        }
        holder.itemView.setOnClickListener {
//            var intent = Intent(context, SampleActivity::class.java)
//            intent.putExtra("user",currentItem.firstName)
//            context.startActivity(intent)
        }
    }

    class SurNameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val cardView: CardView = itemView.card_view_family
        val textView1: TextView = itemView.surname_family
    }
}