package com.xmzlb.iron.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xmzlb.iron.R
import com.xmzlb.iron.base.BaseRecyclerAdapte
import kotlinx.android.synthetic.main.activity_car_identification.*
import kotlinx.android.synthetic.main.include_bottom_2btn.view.*
import kotlinx.android.synthetic.main.include_itembar.view.*
import kotlinx.android.synthetic.main.topbar.*

/**
 * 货车认证
 */
class CarIdentificationActivity : AppCompatActivity() {

    var list = arrayListOf("1", "1", "1", "1")
    var list2 = arrayListOf("1", "1", "1", "1")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_identification)

        topbar_btn_back.setOnClickListener { finish() }
        carIdeItem1.itembar_text.text = "身份认证上传"
        carIdeItem2.itembar_text.text = "货车认证上传"
        carIdeItem3.itembar_text.text = "货车信息"

        bottom_btn.bottom_btn1.text = "提交认证"
        bottom_btn.bottom_btn2.text = "取消认证"

        peopleRec.layoutManager = GridLayoutManager(this, 4)
        peopleRec.adapter = recAdapter().setData(list)

        carRec.layoutManager = GridLayoutManager(this, 4)
        carRec.adapter = recAdapter().setData(list2)
    }

    inner class recAdapter : BaseRecyclerAdapte<String>() {
        override fun onCreate(parent: ViewGroup?, viewType: Int, inflater: LayoutInflater?): RecyclerView.ViewHolder? {
            var view = layoutInflater.inflate(R.layout.item_caridentify, null)
            return MyHolder(view)
        }

        override fun onBind(holder: RecyclerView.ViewHolder?, position: Int, data: String?) {
        }

        inner class MyHolder(view: View) : RecyclerView.ViewHolder(view) {

        }
    }
}
