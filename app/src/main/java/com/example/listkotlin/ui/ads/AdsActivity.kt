package com.example.listkotlin.ui.ads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listkotlin.Model.TempDataModel
import com.example.listkotlin.R
import com.example.listkotlin.ui.gallary.GallaryAdapter
import kotlinx.android.synthetic.main.activity_ads.*
import kotlinx.android.synthetic.main.activity_gallary.*

class AdsActivity : AppCompatActivity() {
    var dataList: MutableList<TempDataModel> = mutableListOf()
    lateinit var myadapter : AdsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ads)

        val toolbar = findViewById<View>(R.id.toolbar_ads) as Toolbar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title = "Advertise"
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)
        val example = generateDummyList(5)
        myadapter = AdsAdapter(example)

        recycler_view_ads.layoutManager = LinearLayoutManager(this)
        recycler_view_ads.adapter = myadapter
        recycler_view_ads.setHasFixedSize(true)
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