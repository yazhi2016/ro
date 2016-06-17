package com.xmzlb.iron.fragment

/**
 * Created by zyz on 2016/5/20 0020.
 * QQ:344100167
 * 首页 -- 运输-- 所有运单 -- 我的抢单
 */
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xmzlb.iron.R
import com.xmzlb.iron.base.BaseRecyclerAdapte
import com.xmzlb.iron.utils.MyGlobal
import kotlinx.android.synthetic.main.fragment_myorderall.*
import kotlinx.android.synthetic.main.item_myorderall.view.*

public open class MyOrderAllFragment(val type: Int = 0) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_myorderall, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        allFraRec.layoutManager = LinearLayoutManager(activity)
        allFraRec.adapter = MyAdapter().setData(MyGlobal.getList())
    }

    inner class MyAdapter : BaseRecyclerAdapte<String>() {
        override fun onCreate(parent: ViewGroup?, viewType: Int, inflater: LayoutInflater?): RecyclerView.ViewHolder? {
            val view = LayoutInflater.from(activity).inflate(R.layout.item_myorderall, null)


            return MyHolder(view)
        }

        override fun onBind(holder: RecyclerView.ViewHolder?, position: Int, data: String?) {
            var colorInt = R.color.green
            var textContent = ""
            var backDrawble = R.drawable.corner_solidwhite_strokegreen
            when (position) {
                0 -> {
                    colorInt = R.color.green
                    textContent = "抢单成功"
                    backDrawble = R.drawable.corner_solidwhite_strokegreen
                }
                1 -> {
                    colorInt = R.color.gray69
                    textContent = "抢单失败"
                    backDrawble = R.drawable.corner_solidwhite_strokegray
                }
                2 -> {
                    colorInt = R.color.black
                    textContent = "完成抢单"
                    backDrawble = R.drawable.corner_solidwhite_strokeblack
                }
                else -> {
                    colorInt = R.color.green
                    textContent = "抢单成功"
                    backDrawble = R.drawable.corner_solidwhite_strokegreen
                }
            }
            holder!!.itemView.myRobOrderStatus.setTextColor(resources.getColor(colorInt))
            holder.itemView.myRobOrderStatus.text = textContent
            if (Build.VERSION.SDK_INT >= 16) {
                holder.itemView.myRobOrderStatus.background = resources.getDrawable(backDrawble)
            } else {
                holder.itemView.myRobOrderStatus.setBackgroundDrawable(resources.getDrawable(backDrawble))
            }
        }

        inner class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
        }
    }
}