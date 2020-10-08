package com.example.listkotlin.ui.family

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listkotlin.Model.TempDataModel
import com.example.listkotlin.R
import kotlinx.android.synthetic.main.activity_family.*


class FamilyActivity : AppCompatActivity() {
    var dataList: MutableList<TempDataModel> = mutableListOf()
    lateinit var myadapter : SurnameAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family)
        val toolbar = findViewById<View>(R.id.toolbar_family) as Toolbar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title = "surname"
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)
//        toolbar_title.text = "surname"
        val example = generateDummyList(50)
        myadapter = SurnameAdapter(example)

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