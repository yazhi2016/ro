package com.xmzlb.iron.fragment

/**
 * Created by zyz on 2016/5/20 0020.
 * QQ:344100167
 * 首页 -- 运输-- 所有运单 -- 已成功
 */
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xmzlb.iron.R

open class MyOrderSucFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_myordersuc, container, false)
    }

}