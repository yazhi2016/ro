package com.xmzlb.iron.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.xmzlb.iron.R
import com.xmzlb.iron.fragment.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    internal var title = arrayOf("行情", "商铺", "供求", "运输", "我的")
    internal var selectIcon = intArrayOf(R.drawable.tab1_select, R.drawable.tab1_select, R.drawable.tab1_select, R.drawable.tab1_select, R.drawable.tab1_select)
    internal var unSelectIcon = intArrayOf(R.drawable.tab1_unselect, R.drawable.tab1_unselect, R.drawable.tab1_unselect, R.drawable.tab1_unselect, R.drawable.tab1_unselect)
    private val mTabEntities = ArrayList<CustomTabEntity>() //底栏的图标、文字信息

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initTabhost()
    }

    private fun initTabhost() {
        for (i in 0..4) {
            val finalI = i
            mTabEntities.add(object : CustomTabEntity {
                override fun getTabTitle(): String {
                    return title[finalI]
                }

                override fun getTabSelectedIcon(): Int {
                    return selectIcon[finalI]
                }

                override fun getTabUnselectedIcon(): Int {
                    return unSelectIcon[finalI]
                }
            })
        }

        tablayout.setTabData(mTabEntities)
        tablayout.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                myPager.setCurrentItem(position, false)
            }

            override fun onTabReselect(position: Int) {

            }
        })

        myPager.adapter = myAdapter(supportFragmentManager)
        myPager.setCanScroll(false)
        myPager.offscreenPageLimit = 5
        myPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                tablayout.currentTab = position
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }

    internal inner class myAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            var fragment: Fragment? = null
            when (position) {
                0 -> fragment = PriceFragment()
                1 -> fragment = ShopFragment()
                2 -> fragment = SupplyFragment()
                3 -> fragment = LogisticsFragment()
                4 -> fragment = MeFragment()
                else -> {
                }
            }

            return fragment!!
        }

        override fun getCount(): Int {
            return 5
        }
    }
}
