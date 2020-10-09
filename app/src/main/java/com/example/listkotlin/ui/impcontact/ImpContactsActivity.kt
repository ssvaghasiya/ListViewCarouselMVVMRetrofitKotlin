package com.example.listkotlin.ui.impcontact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listkotlin.Model.TempDataModel
import com.example.listkotlin.R
import com.example.listkotlin.ui.ads.AdsAdapter
import com.example.listkotlin.ui.gallary.GallaryAdapter
import kotlinx.android.synthetic.main.activity_ads.*
import kotlinx.android.synthetic.main.activity_imp_contacts.*

class ImpContactsActivity : AppCompatActivity() {
    var dataList: MutableList<TempDataModel> = mutableListOf()
    lateinit var myadapter : ImpContactAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imp_contacts)
        val toolbar = findViewById<View>(R.id.toolbar_impcon) as Toolbar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title = "Imp Contacts"
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)
        val example = generateDummyList(10)
        myadapter = ImpContactAdapter(example)

        recycler_view_impcon.layoutManager = LinearLayoutManager(this)
        recycler_view_impcon.adapter = myadapter
        recycler_view_impcon.setHasFixedSize(true)
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