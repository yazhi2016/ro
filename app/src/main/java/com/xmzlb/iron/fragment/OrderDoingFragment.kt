package com.xmzlb.iron.fragment

/**
 * Created by zyz on 2016/5/23 0023.
 * QQ:344100167
 * 我的订单-进行中
 *
 */
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xmzlb.iron.R
import kotlinx.android.synthetic.main.fragment_meorder.*

open class OrderDoingFragment : Fragment() {

    var title = arrayOf("待付款", "待发货", "已发货", "退款中")

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_meorder, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        meOrderFraViewpager.adapter = pagerAdapter(childFragmentManager)
        meOrderFraTablayout.setViewPager(meOrderFraViewpager, title)
    }

    internal inner class pagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            var fragment: Fragment? = null
            when (position) {
                0 -> fragment = MeOrderDoingFragment()
                1 -> fragment = OrderSentFragment(1, 0) //待发货
                2 -> fragment = OrderSentFragment(1, 1) //已发货
                3 -> fragment = MeOrderDoingFragment()
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