package com.xmzlb.iron.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xmzlb.iron.R
import com.xmzlb.iron.activity.*
import kotlinx.android.synthetic.main.fragment_me.*

/**
 * 我的订单-进心中、已完成等
 */
open class MeFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_me, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_myorder.setOnClickListener {
            startActivity(Intent(activity, MyOrderActivity::class.java))
        }
        btn2.setOnClickListener {
            startActivity(Intent(activity, RobOrderDetailActivity::class.java))
        }
        btn3.setOnClickListener {
            startActivity(Intent(activity, OrderDetailActivity::class.java))
        }
        btn4.setOnClickListener {
            startActivity(Intent(activity, LogisticsAssessActivity::class.java))
        }
        btn5.setOnClickListener {
            startActivity(Intent(activity, CarDetailActivity::class.java))
        }
    }

}// Required empty public constructor
