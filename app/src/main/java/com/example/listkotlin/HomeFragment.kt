package com.example.listkotlin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listkotlin.Model.Data
import com.example.listkotlin.ViewModel.CarouselViewModel
import com.squareup.picasso.Picasso
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageClickListener
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var sampleImages = intArrayOf(
        R.drawable.image_1,
        R.drawable.image_2,
        R.drawable.image_3,
        R.drawable.image_4,
        R.drawable.image_5
    )

    var sampleImagesFromApi = mutableListOf<String>()
    var carouselview: CarouselView? = null
    var recycler_view: RecyclerView? = null
    var dataList: MutableList<DataGridHome> = mutableListOf()
    lateinit var myadapter : GridDataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        dataList.add(DataGridHome(R.drawable.gallary,"Gallary"))
        dataList.add(DataGridHome(R.drawable.users,"Users"))
        dataList.add(DataGridHome(R.drawable.ads1,"Advertise"))
        dataList.add(DataGridHome(R.drawable.contact1,"Contact"))
        myadapter = GridDataAdapter(dataList)

        val carouselviewmodel = ViewModelProvider(this).get(CarouselViewModel::class.java)
        carouselviewmodel.getResponseData()

        recycler_view?.layoutManager = GridLayoutManager(activity,2,LinearLayoutManager.VERTICAL,false)
        recycler_view?.adapter = myadapter
        recycler_view?.setHasFixedSize(true)
        recycler_view?.isFocusable = false
        recycler_view?.isNestedScrollingEnabled = false
        recycler_view?.addItemDecoration(SpacesItemDecoration())
        carouselviewmodel.responseLiveData.observe(this, Observer {
            var responsedata: MutableList<Data> = it.data as MutableList<Data>
            for ((i, data) in responsedata.withIndex()) {
                sampleImagesFromApi.add(responsedata[i].avatar)
            }
            Log.d("TAG1", sampleImagesFromApi.toString())
           Log.d("arrsize",sampleImagesFromApi.size.toString())
            carouselview?.setImageListener(imageListener)
            carouselview?.setImageClickListener(imageClickListener)
            carouselview?.setPageCount(sampleImagesFromApi.size)


        })

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root = inflater.inflate(R.layout.fragment_home, container, false)
        carouselview = root.findViewById(R.id.carouselViewHomefrag) as? CarouselView
        recycler_view = root.findViewById(R.id.recycler_view_home) as? RecyclerView
        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView?) {
//            imageView?.setImageResource(sampleImages[position])
            Picasso.get().load(sampleImagesFromApi[position]).placeholder(R.drawable.placeholderimg).into(imageView)
        }
    }

    var imageClickListener: ImageClickListener = object : ImageClickListener {
        override fun onClick(position: Int) {
            Toast.makeText(activity,"Carousel $position", Toast.LENGTH_SHORT).show()
        }
    }
}