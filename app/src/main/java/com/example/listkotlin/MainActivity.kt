package com.example.listkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val language = resources.getStringArray(R.array.language)
        val arrayAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,language)
        listView.adapter = arrayAdapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            val item = adapterView.getItemAtPosition(position) as String
            val itemID = adapterView.getItemIdAtPosition(position)
            var intent = Intent(this,HomePageActivity::class.java)
            intent.putExtra("language",item)
            startActivity(intent)
            Toast.makeText(this,"${item+" "+itemID}",Toast.LENGTH_SHORT).show()
        }
    }
}