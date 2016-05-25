package com.xmzlb.iron.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.View
import com.xmzlb.iron.R
import com.xmzlb.iron.base.BaseActivity
import com.xmzlb.iron.fragment.OrderDoingFragment
import kotlinx.android.synthetic.main.activity_my_order.*
import kotlinx.android.synthetic.main.topbar.*

/**
 * 我的订单
 */
class MyOrderActivity : BaseActivity() {

    var title = arrayOf("进行中","已完成", "已关闭")

    override fun onClick(v: View?) {
    }

    override fun initEvents() {
    }

    override fun init() {
        topbar_text.text = "我的订单"
        topbar_btn_share.visibility = View.GONE
        topbar_btn_back.setOnClickListener { finish() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_order)
        init() //初始化顶栏
        myoActViewpager.adapter = pagerAdapter(supportFragmentManager)
        myoActTablayout.setViewPager(myoActViewpager, title)
    }

    internal inner class pagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            var fragment: Fragment? = null
            when (position) {
                0 -> fragment = OrderDoingFragment() //进行中
                1 -> fragment = OrderDoingFragment()
                2 -> fragment = OrderDoingFragment()
            }
            return fragment!!
        }

        override fun getCount(): Int {
            return 3
        }

        override fun getPageTitle(position: Int): CharSequence {
            return title[position]
        }
    }
}
