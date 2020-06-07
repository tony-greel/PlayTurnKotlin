package com.diabin.festec.playturnkotlin.basis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gyf.barlibrary.ImmersionBar

abstract class BasisFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ImmersionBar.with(this).init()
        automaticOpenRefresh()
        automaticCloseRefresh()
        val view = inflater.inflate(getLayoutFile(),container,false)
        initView(view)
        return view
    }

    abstract fun initView(view: View?)

    abstract fun automaticCloseRefresh()

    abstract fun automaticOpenRefresh()


    abstract fun getLayoutFile(): Int
}