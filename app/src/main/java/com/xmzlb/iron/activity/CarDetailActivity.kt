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
import kotlinx.android.synthetic.main.activity_car_detail.*
import kotlinx.android.synthetic.main.topbar.*

/**
 * 货车详情
 */
class CarDetailActivity : AppCompatActivity() {

    var list = arrayListOf("1", "1", "1", "1", "1", "1", "1", "1")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_detail)

        topbar_btn_back.setOnClickListener { finish() }

        carDetailRec.layoutManager = GridLayoutManager(this, 4)
        carDetailRec.adapter = recAdapter().setData(list)
    }

    inner class recAdapter : BaseRecyclerAdapte<String>() {
        override fun onCreate(parent: ViewGroup?, viewType: Int, inflater: LayoutInflater?): RecyclerView.ViewHolder? {
            var view = layoutInflater.inflate(R.layout.item_cardetailrec, null)
            return MyHolder(view)
        }

        override fun onBind(holder: RecyclerView.ViewHolder?, position: Int, data: String?) {
        }

        inner class MyHolder(view: View) : RecyclerView.ViewHolder(view) {

        }
    }
}
