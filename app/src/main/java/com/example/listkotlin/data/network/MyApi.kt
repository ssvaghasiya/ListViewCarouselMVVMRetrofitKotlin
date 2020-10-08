package com.example.listkotlin.data.network

import com.example.listkotlin.Model.ReqResUser
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


//const val BASE_URL = "https://reqres.in"
interface MyApi {

    @GET("/api/users?page=2")
    fun getData(): Call<ReqResUser>

//    companion object{
//        operator fun invoke(): MyApi{
//            return Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(MyApi::class.java)
//        }
//    }
}