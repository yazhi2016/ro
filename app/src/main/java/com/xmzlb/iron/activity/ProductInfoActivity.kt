package com.xmzlb.iron.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import com.xmzlb.iron.R
import com.xmzlb.iron.fragment.ConnectProductFragment
import com.xmzlb.iron.fragment.ProductFragment
import com.xmzlb.iron.fragment.RecommendLogisticsFragment
import com.xmzlb.iron.fragment.RecommendShopFragment
import kotlinx.android.synthetic.main.activity_product_info.*
import kotlinx.android.synthetic.main.topbar.*

/**
 * 商品动态、关联商品界面
 */
class ProductInfoActivity : AppCompatActivity() {

    internal var str = arrayOf("商品动态", "关联商品", "推荐店铺", "推荐物流")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_info)

        topbar_btn_back.setOnClickListener { finish() }

        product_viewpager.adapter = pagerAdapter(supportFragmentManager)
        product_flycoLayout.setViewPager(product_viewpager, str)
    }

    internal inner class pagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            var fragment: Fragment? = null
            when (position) {
                0 -> fragment = ProductFragment()
                1 -> fragment = ConnectProductFragment()
                2 -> fragment = RecommendShopFragment()
                3 -> fragment = RecommendLogisticsFragment()
            }
            return fragment!!
        }

        override fun getCount(): Int {
            return 4
        }

        override fun getPageTitle(position: Int): CharSequence {
            return str[position]
        }
    }
}
