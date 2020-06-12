package com.udacoding.newsapimvp.presenter

import com.udacoding.newsapimvp.model.ArticlesItem

//todo 5
interface NewsView {

    fun onSuccess(msg : String,article : List<ArticlesItem?>?)
    fun onError(msg : String)
}