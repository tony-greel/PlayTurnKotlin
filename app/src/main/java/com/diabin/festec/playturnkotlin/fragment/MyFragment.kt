package com.diabin.festec.playturnkotlin.fragment

import android.view.View
import com.diabin.festec.playturnkotlin.R
import com.diabin.festec.playturnkotlin.basis.BasisFragment

class MyFragment : BasisFragment() {
    override fun automaticCloseRefresh() {
    }

    override fun automaticOpenRefresh() {
    }

    override fun initView(view: View?) {
    }

    override fun getLayoutFile(): Int {
        return R.layout.fragment_my
    }
}