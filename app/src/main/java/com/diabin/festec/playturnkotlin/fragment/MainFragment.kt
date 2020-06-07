package com.diabin.festec.playturnkotlin.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.diabin.festec.playturnkotlin.R
import com.diabin.festec.playturnkotlin.api.Api
import com.diabin.festec.playturnkotlin.basis.BasisFragment
import com.diabin.festec.playturnkotlin.bean.CarouselBean
import com.diabin.festec.playturnkotlin.http.RetrofitClient
import com.diabin.festec.playturnkotlin.tool.PictureLoaderTool
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.fragment_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate

class MainFragment : BasisFragment() {

    private var mainBanner : Banner ?= null

    override fun getLayoutFile(): Int {
        return R.layout.fragment_main
    }

    override fun initView(view: View?) {
        mainBanner = view?.findViewById(R.id.mainBanner)
        initData()
    }

    private fun initData() {


        val call = RetrofitClient.getInstance().getRetrofit(Api.baseUrl).create(Api::class.java).fetch()
        call.enqueue(object : Callback<CarouselBean> {
            override fun onResponse(call: Call<CarouselBean>, response: Response<CarouselBean>?) {
                val model = response?.body()
                Toast.makeText(context,"成功",Toast.LENGTH_SHORT).show()
                Log.d("MainFragment",model.toString())
                val arrayImageUrl:ArrayList<String> = arrayListOf()
                for (value in model?.data!!) {
                    Log.d("MainFragment---",value.title)
                    arrayImageUrl.add(value.title)
                }

                if (arrayImageUrl != null) {
                    for (ca in arrayImageUrl){
                        Log.d("MainFragment-+--",ca)

                    }
                }

            }

            override fun onFailure(call: Call<CarouselBean>, t: Throwable) {
                Toast.makeText(context,"失败",Toast.LENGTH_SHORT).show()

            }

        })

        val arrayImageUrl = arrayListOf<String>("http://image.biaobaiju.com/uploads/20181025/19/1540467434-IhiJNbyXak.jpg",
            "http://gss0.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/060828381f30e924ce9f0a854e086e061d95f74f.jpg",
            "http://5b0988e595225.cdn.sohucs.com/q_70,c_zoom,w_640/images/20200105/c5162a9d6f484ce3b8ff464b27f8865f.jpeg")
        val arrayTitle = arrayListOf<String>("第一张", "第二张", "第三张")

        if(mainBanner != null) {
            //设置内置样式，共有六种可以点入方法内逐一体验使用。
            mainBanner?.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
            //设置图片加载器，图片加载器在下方
            mainBanner?.setImageLoader(MyLoader())
            //设置图片网址或地址的集合
            mainBanner?.setImages(arrayImageUrl)
            //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
            mainBanner?.setBannerAnimation(Transformer.Default)
            //设置轮播图的标题集合
            mainBanner?.setBannerTitles(arrayTitle)
            //设置轮播间隔时间
            mainBanner?.setDelayTime(3000)
            //设置是否为自动轮播，默认是“是”。
            mainBanner?.isAutoPlay(true)
            //设置指示器的位置，小点点，左中右。
            mainBanner?.setIndicatorGravity(BannerConfig.CENTER)
            //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。

            mainBanner?.setOnBannerListener {
                Log.d("=*=", "第几张" + it.dec())
            }
            //必须最后调用的方法，启动轮播图。
            mainBanner?.start()
        }else{
            Toast.makeText(context,"aaaaaaaa",Toast.LENGTH_SHORT).show()

        }
    }

    override fun automaticCloseRefresh() {
    }

    override fun automaticOpenRefresh() {
    }

    //自定义的图片加载器
    private inner class MyLoader : ImageLoader() {
        override fun displayImage(context: Context, path: Any, imageView: ImageView) {
            Glide.with(context).load(path as String).into(imageView)
        }


    }

}