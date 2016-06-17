package com.xmzlb.iron.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.xmzlb.iron.R
import kotlinx.android.synthetic.main.activity_rob_order_detail2.*
import kotlinx.android.synthetic.main.include_itembar_title.*
import kotlinx.android.synthetic.main.include_roborderdetail2.view.*
import kotlinx.android.synthetic.main.topbar.*

class RobOrderDetailActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rob_order_detail2)

        topbar_text.text = "抢单详情"
        topbar_btn_back.setOnClickListener { finish() }

        text_name.text = "幸福一家"

        goods.text_item.text = "商品"
        weight.text_item.text = "重量"
        begin.text_item.text = "起点"
        end.text_item.text = "终点"
        goods.text_message.text = "螺纹钢"
        weight.text_message.text = "8吨"
        begin.text_message.text = "厦门"
        end.text_message.text = "上海"
        phone.text_message.text = "123124314"
        phone.text_item.text = "联系电话"

        statusbar.changeStatus(3)
    }
}
