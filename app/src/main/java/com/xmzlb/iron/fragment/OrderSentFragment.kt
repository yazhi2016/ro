package com.xmzlb.iron.fragment

/**
 * Created by zyz on 2016/5/20 0020.
 * QQ:344100167
 * 我的订单-已发货
 */
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xmzlb.iron.R
import com.xmzlb.iron.activity.LookLogisticsActivity
import com.xmzlb.iron.base.BaseRecyclerAdapte
import kotlinx.android.synthetic.main.fragment_ordersent.*
import kotlinx.android.synthetic.main.item_order_sent.view.*

/**
 * 我的订单-进心中-已发货（type = 1）
 */
public open class OrderSentFragment(val type: Int) : Fragment() {

    var adapter = orderSentFraRecAdapter()
    var carList = arrayOf("car1", "car2", "car3")
    var carList2 = arrayListOf("c1", "c2", "c1", "c2", "c3")

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_ordersent, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        orderSentFraRec.layoutManager = LinearLayoutManager(activity)
        orderSentFraRec.adapter = adapter.setData(carList2)
    }

    inner class orderSentFraRecAdapter : BaseRecyclerAdapte<String>() {
        override fun onCreate(parent: ViewGroup?, viewType: Int, inflater: LayoutInflater?): RecyclerView.ViewHolder? {
            if (viewType == 0) {
                var view = LayoutInflater.from(activity).inflate(R.layout.item_order_sent, null)
                var btnStr = ""
                var textStr = ""
                when (type) {
                    0 -> {
                        btnStr = "发货"
                        textStr = "等待发货"
                    }
                    1 -> {
                        btnStr = "查看物流"
                        textStr = "已发货"
                    }
                }
                view.item_btnOrderSent.text = btnStr
                view.text_state.text = textStr
                return orderSentFraRecHolder(view)
            } else {
                var view = LayoutInflater.from(activity).inflate(R.layout.item_order_sent_carlist_item, null)
                return orderSentFraRecHolder(view)
            }
        }

        override fun onBind(holder: RecyclerView.ViewHolder?, position: Int, data: String?) {
            holder?.itemView?.item_btnOrderSent?.setOnClickListener {
                if (type == 0) { //发货
                    holder?.itemView?.linear_newbtn?.visibility = View.VISIBLE
                    holder?.itemView?.line_bottom?.visibility = View.VISIBLE
                    holder?.itemView?.item_btnOrderSent?.visibility = View.GONE
                    Log.e("==", "position" + position)
                    carList2.add(position + 1, "list")
                    carList2.add(position + 1, "list")
                    carList2.add(position + 1, "list")
                    adapter.notifyDataSetChanged()
                } else { //查看物流
                    startActivity(Intent(activity, LookLogisticsActivity::class.java))
                }
            }
        }

        override fun getItemViewType(position: Int): Int {
            if (carList2.get(position).equals("list")) return 1 else return 0
        }

        inner class orderSentFraRecHolder(view: View) : RecyclerView.ViewHolder(view) {

        }
    }

}