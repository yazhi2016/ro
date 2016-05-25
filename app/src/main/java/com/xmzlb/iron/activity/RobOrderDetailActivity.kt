package com.xmzlb.iron.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.xmzlb.iron.R
import kotlinx.android.synthetic.main.activity_rob_order_detail.*
import kotlinx.android.synthetic.main.include_roborderdetail.view.*
import kotlinx.android.synthetic.main.topbar.*

/**
 * 抢单详情
 */
class RobOrderDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rob_order_detail)

        goods.text_item.text = "商品"
        weight.text_item.text = "重量"
        begin.text_item.text = "起点"
        end.text_item.text = "终点"
        seller.text_item.text = "订单商家"
        phone.text_item.text = "联系电话"
        pay.text_item.text = "我出价"
        state.text_item.text = "状态"

        topbar_btn_back.setOnClickListener { finish() }
    }
}
