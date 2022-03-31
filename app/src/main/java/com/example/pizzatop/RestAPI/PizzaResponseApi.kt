package com.example.pizzatop.RestAPI

import com.example.pizzatop.Data.Menu

import retrofit2.Call
import retrofit2.http.GET

interface PizzaResponseApi {
    @GET("./restaurants/1/menu")
    fun getInfo():Call<Menu>
}