package com.diabin.festec.playturnkotlin.basis

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gyf.barlibrary.ImmersionBar

abstract class BasisActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutFile())
        ImmersionBar.with(this).init()
        initView()
        initData()
    }

    abstract fun getLayoutFile(): Int

    abstract fun initView()
    private fun initData(){}
}