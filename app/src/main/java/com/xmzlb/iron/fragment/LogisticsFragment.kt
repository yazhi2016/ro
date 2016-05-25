package com.xmzlb.iron.fragment


import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import com.xmzlb.iron.R
import kotlinx.android.synthetic.main.fragment_logistics_blank.*
import kotlinx.android.synthetic.main.topbar2.*

/**
 * 首页 运输
 */
class LogisticsFragment : Fragment() {

    val title = arrayOf("所有运单", "货车列表", "我的抢单")
    var pop: PopupWindow? = null
    var popview: View? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_logistics_blank, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logFraViewpager.adapter = pagerAdapter(childFragmentManager)
        logFraViewpager.offscreenPageLimit = 3
        logFraTablayout.setViewPager(logFraViewpager, title)

        topbar2_btn_set.setOnClickListener {
            pop?.showAsDropDown(topbar)
        }

        popview = LayoutInflater.from(activity).inflate(R.layout.pop_topbar_set, null)
        pop = PopupWindow(popview, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true)
        val b = BitmapDrawable()
        pop?.setBackgroundDrawable(b)
    }

    internal inner class pagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            var fragment: Fragment? = null
            when (position) {
                0 -> fragment = AllOrderFragment()
                1 -> fragment = CarListFragment()
                2 -> fragment = MyOrderFragment()
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

}// Required empty public constructor
