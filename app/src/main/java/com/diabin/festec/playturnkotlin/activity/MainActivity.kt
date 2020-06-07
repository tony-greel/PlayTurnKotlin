package com.diabin.festec.playturnkotlin.activity

import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.diabin.festec.playturnkotlin.R
import com.diabin.festec.playturnkotlin.adapter.TitleFragmentPagesAdapter
import com.diabin.festec.playturnkotlin.basis.BasisActivity
import com.diabin.festec.playturnkotlin.fragment.MainFragment
import com.diabin.festec.playturnkotlin.fragment.MyFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 如果要对TabLayout进行监听处理，请继承该接口OnTabSelectedListener
 */
class MainActivity : BasisActivity(){

    override fun getLayoutFile(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        MainVp.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(MainTl))
        setTitle()
        setItem();
    }

    private fun setTitle() {
        val mainTitle = MainFragment()
        val myTitle = MyFragment()
        var fragmentList = listOf<Fragment>(mainTitle, myTitle)
        MainVp.adapter = TitleFragmentPagesAdapter(fragmentList, supportFragmentManager)
        MainTl.setupWithViewPager(MainVp)
    }

    private fun setItem() {
        val list = listOf("主页", "我的")
        MainTl.getTabAt(0)?.text = list[0]
        MainTl.getTabAt(1)?.text = list[1]
        MainTl.getTabAt(2)?.text = list[2]
    }

}
