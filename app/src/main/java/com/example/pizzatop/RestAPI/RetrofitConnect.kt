package com.example.pizzatop.RestAPI

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConnect {
    private val url="https://private-anon-3d00b87e08-pizzaapp.apiary-mock.com/"
    private fun Retrofit(): Retrofit {
        val log = HttpLoggingInterceptor()
        log.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(log).build()
        return Retrofit.Builder().baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient).build()
    }
    fun create(): PizzaResponseApi? {
        return Retrofit().create(PizzaResponseApi::class.java)
    }
}