package com.example.listkotlin.ui.gallary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listkotlin.Model.TempDataModel
import com.example.listkotlin.R
import com.example.listkotlin.ui.family.SurnameAdapter
import kotlinx.android.synthetic.main.activity_family.*

class GallaryActivity : AppCompatActivity() {
    var dataList: MutableList<TempDataModel> = mutableListOf()
    lateinit var myadapter : GallaryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallary)
        val toolbar = findViewById<View>(R.id.toolbar_family) as Toolbar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title = "gallary"
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)
//        toolbar_title.text = "surname"
        val example = generateDummyList(5)
        myadapter = GallaryAdapter(example)

        recycler_view_family.layoutManager = LinearLayoutManager(this)
        recycler_view_family.adapter = myadapter
        recycler_view_family.setHasFixedSize(true)
    }

    private fun generateDummyList(size: Int): MutableList<TempDataModel>{
        val list = ArrayList<TempDataModel>()

        for(i in 0 until size){
            val item = TempDataModel("Kartum $i",R.drawable.image_3)
            list += item
        }
        return list
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}