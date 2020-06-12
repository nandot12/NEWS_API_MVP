package com.udacoding.newsapimvp.presenter

import com.udacoding.newsapimvp.model.ResponseServer
import com.udacoding.newsapimvp.network.ConfigRetrofit
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//todo 6
class NewsPresenter(val news : NewsView) {


    //todo 4
    fun getNews(){

        ConfigRetrofit.getRetrofit().getData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                response ->
                if(response.totalResults == 200){
                    news.onSuccess(response.status ?: "",response.articles)
                }
            },{
                e ->
                news.onError(e.localizedMessage)
            })

//        ConfigRetrofit.getRetrofit().getData().enqueue(object :Callback<ResponseServer>{
//            override fun onFailure(call: Call<ResponseServer>, t: Throwable) {
//
//                ////todo 9
//                news.onError(t.message ?: "")
//            }
//
//            override fun onResponse(
//                call: Call<ResponseServer>,
//                response: Response<ResponseServer>
//            ) {
//
//                if(response.isSuccessful){
//
//                    val dataNews = response.body()?.articles
//                    if(dataNews?.size ?: 0 > 0 ){
//                        //todo 7
//                        news.onSuccess(response.message(),dataNews)
//
//                    }
//                    else{
//                        //todo 8
//                        news.onError("data kosong")
//
//                    }
//                }
//            }
//        })
    }
}