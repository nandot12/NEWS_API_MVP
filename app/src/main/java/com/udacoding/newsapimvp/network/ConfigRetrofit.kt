package com.udacoding.newsapimvp.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ConfigRetrofit {


    companion object {

    //todo 3 inisialisasi retrofit
    fun getRetrofit() : NewsService {

        val retrofit = Retrofit.Builder()
            .baseUrl("http://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        var service = retrofit.create(NewsService::class.java)

        return service


    }
}
}