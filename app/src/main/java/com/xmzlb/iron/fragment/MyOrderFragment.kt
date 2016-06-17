package com.xmzlb.iron.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xmzlb.iron.R
import kotlinx.android.synthetic.main.fragment_myorder.*

/**
 * Created by zyz on 2016/5/20 0020.
 * QQ:344100167
 *
 */

open class MyOrderFragment : Fragment() {

    val title = arrayOf("所有运单", "抢单成功", "抢单失败", "完成抢单")

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_myorder, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myOrFraViewpager.adapter = pagerAdapter(childFragmentManager)
        myOrFraViewpager.offscreenPageLimit = 3
        myoFraTablayout.setViewPager(myOrFraViewpager, title)
    }

    internal inner class pagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            var fragment: Fragment? = null
            when (position) {
                0 -> fragment = MyOrderAllFragment(position)
                1 -> fragment = MyOrderAllFragment(position)
                2 -> fragment = MyOrderAllFragment(position)
                3 -> fragment = MyOrderAllFragment(position)
            }
            return fragment!!
        }

        override fun getCount(): Int {
            return 4
        }

        override fun getPageTitle(position: Int): CharSequence {
            return title[position]
        }
    }

}