package com.diabin.festec.playturnkotlin.api

import com.diabin.festec.playturnkotlin.bean.CarouselBean
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    companion object{
        const val baseUrl = "https://www.wanandroid.com/"
    }

    @GET("banner/json")
    fun fetch(): Call<CarouselBean>
}