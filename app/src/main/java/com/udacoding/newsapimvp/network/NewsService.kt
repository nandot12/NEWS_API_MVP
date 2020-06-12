package com.udacoding.newsapimvp.network

import com.udacoding.newsapimvp.model.ResponseServer
import io.reactivex.rxjava3.core.Flowable
import retrofit2.Call
import retrofit2.http.GET


//todo 4
interface NewsService {

    @GET("everything?q=bitcoin&from=2020-05-08&sortBy=publishedAt&apiKey=7e16ba0716d5468c8828539a5f856c34")
    fun getData():Flowable<ResponseServer>
}