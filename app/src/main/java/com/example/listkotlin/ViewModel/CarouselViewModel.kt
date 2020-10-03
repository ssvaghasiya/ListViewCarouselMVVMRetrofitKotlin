package com.example.listkotlin.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.listkotlin.Model.ReqResUser
import com.example.listkotlin.data.reposiory.UserRepository

class CarouselViewModel: ViewModel() {
    var responseLiveData = MutableLiveData<ReqResUser>()
    fun getResponseData(){
        responseLiveData = UserRepository().getApiData()
    }
}