//https://medium.com/@lobothijau/create-carousel-easily-in-android-app-with-carouselview-6cbf5ef500a9

package com.example.listkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.listkotlin.Model.Data
import com.example.listkotlin.ViewModel.CarouselViewModel
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener

class HomePageActivity : AppCompatActivity() {

    var sampleImages = intArrayOf(
        R.drawable.image_1,
        R.drawable.image_2,
        R.drawable.image_3,
        R.drawable.image_4,
        R.drawable.image_5
    )

    var sampleImagesFromApi = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val carouselview = findViewById(R.id.carouselView) as CarouselView;

        val carouselviewmodel = ViewModelProvider(this).get(CarouselViewModel::class.java)
        carouselviewmodel.getResponseData()
        carouselviewmodel.responseLiveData.observe(this, Observer {
            var responsedata: MutableList<Data> = it.data as MutableList<Data>
            for ((i, data) in responsedata.withIndex()) {
                sampleImagesFromApi.add(responsedata[i].avatar)
            }
            Log.d("TAG1", sampleImagesFromApi.toString())
            carouselview.setPageCount(sampleImagesFromApi.size)
        })
        carouselview.setImageListener(imageListener)
    }

    var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView?) {
//            imageView?.setImageResource(sampleImages[position])
            Picasso.get().load(sampleImagesFromApi[position]).placeholder(R.drawable.placeholderimg).networkPolicy(NetworkPolicy.NO_CACHE).into(imageView)
        }

    }
}