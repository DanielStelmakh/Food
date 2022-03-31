package com.example.pizzatop.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pizzatop.Data.Info
import com.example.pizzatop.Data.Menu
import com.example.pizzatop.RestAPI.RetrofitConnect
import com.example.pizzatop.repositoryimages.DataBanner
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BaseViewModel:ViewModel() {
    val liveData = MutableLiveData<ArrayList<String>>()
    val liveData1 = MutableLiveData<ArrayList<Info>>()
    private val retrofitConnect = RetrofitConnect().create()

    init {
        val list = DataBanner().returnList()
        liveData.value = list
        retrofitConnect?.getInfo()?.enqueue(object : Callback<Menu> {
            override fun onResponse(call: Call<Menu>, response: Response<Menu>) {
                if (response.isSuccessful)
                    liveData1.value = response.body()
            }

            override fun onFailure(call: Call<Menu>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}


