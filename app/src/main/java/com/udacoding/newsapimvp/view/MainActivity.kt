package com.udacoding.newsapimvp.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.udacoding.newsapimvp.R
import com.udacoding.newsapimvp.model.ArticlesItem
import com.udacoding.newsapimvp.presenter.NewsPresenter
import com.udacoding.newsapimvp.presenter.NewsView

class MainActivity : AppCompatActivity(), NewsView {

    //todo 10 deklarasi variable presenter
    private var presenter : NewsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //todo 11 init presenter
        presenter = NewsPresenter(this)
        presenter?.getNews()

    }

    override fun onSuccess(msg: String, article: List<ArticlesItem?>?) {
        //bind data ke recyclerview
        for(i in article?.indices ?: 0..1){
            Log.d("data news",article?.get(i)?.author)
        }
    }

    override fun onError(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
        //
    }
}