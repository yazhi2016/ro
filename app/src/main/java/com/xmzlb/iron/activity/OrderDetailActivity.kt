package com.xmzlb.iron.activity

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.xmzlb.iron.R
import com.xmzlb.iron.weight.MyDialog
import kotlinx.android.synthetic.main.activity_order_detail.*
import kotlinx.android.synthetic.main.include_roborderdetail.view.*
import kotlinx.android.synthetic.main.topbar.*

class OrderDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)

        topbar_btn_back.setOnClickListener { finish() }
        topbar_text.text = "订单详情"

        goods.text_item.text = "商品"
        weight.text_item.text = "重量"
        begin.text_item.text = "起点"
        end.text_item.text = "终点"
        seller.text_item.text = "订单商家"
        phone.text_item.text = "联系电话"

        goods.text_message .text = "螺纹钢"
        weight.text_message .text = "8吨"
        begin.text_message .text = "厦门"
        end.text_message .text = "上海"
        seller.text_message .text = "钢铁一号"
        phone.text_message .text = "123124314"
        phone.phoneIcon.visibility = View.VISIBLE

        btn_rob.setOnClickListener {
            var builder = MyDialog.Companion.Builder(this, null, null, "认证", "取消")
            builder.yesClickListener = DialogInterface.OnClickListener { dialogInterface, i -> }
            builder.noClickListener = DialogInterface.OnClickListener { dialogInterface, i -> }
            builder.create().show()
        }
    }
}
