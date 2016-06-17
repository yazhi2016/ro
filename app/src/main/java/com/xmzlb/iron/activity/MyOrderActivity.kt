package com.xmzlb.iron.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.View
import com.xmzlb.iron.R
import com.xmzlb.iron.base.BaseActivity
import com.xmzlb.iron.fragment.OrderSentFragment
import kotlinx.android.synthetic.main.activity_my_order.*
import kotlinx.android.synthetic.main.topbar.*

/**
 * 我的订单
 */
public class MyOrderActivity : BaseActivity() {

    var title = arrayOf("全部", "待付款", "待发货", "待收货", "待评价")

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
//        myoActViewpager.offscreenPageLimit = 2
        myoActTablayout.setViewPager(myoActViewpager, title)
    }

    internal inner class pagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            var fragment: Fragment? = null
            val fromType = 1 //买家
            when (position) {
//                0 -> fragment = OrderDoingFragment() //进行中
                0 -> fragment = OrderSentFragment(fromType, 0) //进行中
                1 -> fragment = OrderSentFragment(fromType, 1)
                2 -> fragment = OrderSentFragment(fromType, 2) //待发货
                3 -> fragment = OrderSentFragment(fromType, 3) //待收货
                4 -> fragment = OrderSentFragment(fromType, 4)
            }
            return fragment!!
        }

        override fun getCount(): Int {
            return 5
        }

        override fun getPageTitle(position: Int): CharSequence {
            return title[position]
        }
    }
}
