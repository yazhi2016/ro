package com.xmzlb.iron.activity

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.xmzlb.iron.R
import com.xmzlb.iron.weight.MyDialog
import kotlinx.android.synthetic.main.activity_order_detail.*
import kotlinx.android.synthetic.main.include_bottom_btn.view.*
import kotlinx.android.synthetic.main.include_itembar_title.*
import kotlinx.android.synthetic.main.include_roborderdetail2.view.*
import kotlinx.android.synthetic.main.topbar.*

class OrderDetailActivity : AppCompatActivity() {

    lateinit var recgonize: MyDialog
    lateinit var priceDialog: MyDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)

        topbar_btn_back.setOnClickListener { finish() }
        topbar_text.text = "订单详情"

        text_name.text = "钢铁一号"
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
//        seller.text_message.text = "钢铁一号"

//        phone.phoneIcon.visibility = View.VISIBLE

        bottom.bottom_btn.text = "抢单"
        bottom.bottom_btn.setOnClickListener {
//            var builder = MyDialog.Companion.Builder(this, null, "需要认证才可抢单！", "认证", "取消")
//            builder.yesClickListener = DialogInterface.OnClickListener { dialogInterface, i -> }
//            builder.noClickListener = DialogInterface.OnClickListener { dialogInterface, i -> recgonize.dismiss() }
//            recgonize = builder.create()
//            recgonize.show()

            var builder = MyDialog.Companion.Builder(this, "运输价格", "test message1", "确认", "取消", 1)
            builder.yesClickListener = DialogInterface.OnClickListener { dialogInterface, i -> }
            builder.noClickListener = DialogInterface.OnClickListener { dialogInterface, i -> priceDialog.dismiss()}
            priceDialog = builder.create()
            priceDialog.show()
        }
    }
}
