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
import kotlinx.android.synthetic.main.activity_order_evaluate.*
import kotlinx.android.synthetic.main.topbar.*

/**
 * 订单评价
 */
class OrderEvaluateActivity : AppCompatActivity() {

    var list = arrayListOf("1", "1", "1", "1")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_evaluate)

        topbar_btn_back.setOnClickListener { finish() }
        topbar_text.text = "发表评价"

        orderEvaluRec.layoutManager = GridLayoutManager(this, 4)
        orderEvaluRec.adapter =orderEvaluRecAdapter().setData(list)
    }


    inner class orderEvaluRecAdapter: BaseRecyclerAdapte<String>() {
        override fun onCreate(parent: ViewGroup?, viewType: Int, inflater: LayoutInflater?): RecyclerView.ViewHolder? {
            var view = inflater!!.inflate(R.layout.item_caridentify, null)
            return MyHolder(view)
        }

        override fun onBind(holder: RecyclerView.ViewHolder?, position: Int, data: String?) {

        }

        inner class MyHolder(view: View) : RecyclerView.ViewHolder(view) {

        }
    }
}
