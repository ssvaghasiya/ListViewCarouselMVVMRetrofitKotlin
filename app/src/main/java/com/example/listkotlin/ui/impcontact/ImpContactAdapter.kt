package com.example.listkotlin.ui.impcontact

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listkotlin.Model.TempDataModel
import com.example.listkotlin.R
import kotlinx.android.synthetic.main.impcon_item.view.*

class ImpContactAdapter(private val exapmleList: MutableList<TempDataModel>): RecyclerView.Adapter<ImpContactAdapter.ImpConViewHolder>() {
    lateinit var  context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImpConViewHolder {
        context = parent.context
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.impcon_item,parent,false)
        return ImpConViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return exapmleList.size
    }

    override fun onBindViewHolder(holder: ImpConViewHolder, position: Int) {
        var currentItem = exapmleList[position]

        holder.textView1.text = currentItem.text
        holder.textView2.text = currentItem.text

        holder.itemView.setOnClickListener {
//            var intent = Intent(context, SampleActivity::class.java)
//            intent.putExtra("user",currentItem.firstName)
//            context.startActivity(intent)
        }
    }

    class ImpConViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView1: TextView = itemView.textview_impcon1
        val textView2: TextView = itemView.textview_impcon2
        val button: Button = itemView.button_impcon
    }
}