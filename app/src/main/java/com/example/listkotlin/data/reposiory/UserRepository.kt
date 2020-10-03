package com.example.listkotlin.data.reposiory

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.listkotlin.Model.ReqResUser
import com.example.listkotlin.data.network.MyApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    fun getApiData() : MutableLiveData<ReqResUser>{
        val dataResponse = MutableLiveData<ReqResUser>()

        MyApi().getData()
            .enqueue(object : Callback<ReqResUser>{
                override fun onResponse(call: Call<ReqResUser>, response: Response<ReqResUser>) {
                    if(response.isSuccessful){
                        dataResponse.value = response.body()
                        Log.d("APIRESPONSEFROM",response.body().toString())
                    }
                }

                override fun onFailure(call: Call<ReqResUser>, t: Throwable) {
                    Log.d("ErrorOnFailure","Error",t)
                }

            })
        return dataResponse
    }
}