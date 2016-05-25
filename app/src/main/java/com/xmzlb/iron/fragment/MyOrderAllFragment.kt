package com.xmzlb.iron.fragment

/**
 * Created by zyz on 2016/5/20 0020.
 * QQ:344100167
 * 首页 -- 运输-- 所有运单 -- 我的抢单
 */
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xmzlb.iron.R
import com.xmzlb.iron.base.BaseRecyclerAdapte
import com.xmzlb.iron.utils.GlobalParames
import kotlinx.android.synthetic.main.fragment_myorderall.*
import kotlinx.android.synthetic.main.item_myorderall.view.*

public open class MyOrderAllFragment(val type:Int = 0) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_myorderall, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        allFraRec.layoutManager = LinearLayoutManager(activity)
        allFraRec.adapter = MyAdapter().setData(GlobalParames.getList())
    }

    inner class MyAdapter : BaseRecyclerAdapte<String>() {
        override fun onCreate(parent: ViewGroup?, viewType: Int, inflater: LayoutInflater?): RecyclerView.ViewHolder? {
            val view = LayoutInflater.from(activity).inflate(R.layout.item_myorderall, null)
            view.allFraItemName.text = "type is $type"
            var colorInt = R.color.green
            when(type) {
                0 -> colorInt = R.color.green
                1 -> colorInt = R.color.black
                2 -> colorInt = R.color.green
                3 -> colorInt = R.color.black
            }
            view.allFraItemPrice.setTextColor(resources.getColor(colorInt))
            return MyHolder(view)
        }

        override fun onBind(holder: RecyclerView.ViewHolder?, position: Int, data: String?) {
        }

        inner class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
        }
    }
}