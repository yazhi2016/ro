package com.xmzlb.iron.fragment

/**
 * Created by zyz on 2016/5/20 0020.
 * QQ:344100167
 * 我的订单-已发货
 */
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xmzlb.iron.R
import com.xmzlb.iron.activity.LookLogisticsActivity
import com.xmzlb.iron.activity.OrderEvaluateActivity
import com.xmzlb.iron.base.BaseRecyclerAdapte
import com.xmzlb.iron.weight.MyDialog
import kotlinx.android.synthetic.main.fragment_ordersent.*
import kotlinx.android.synthetic.main.item_order_sent.view.*

/**
 * 我的订单-进心中-已发货
 * fromType:0 卖家， 1 买家
 * type：0 全部，1待付款，2待发货，3待收货，4待评价
 */
public open class OrderSentFragment(val fromType: Int, val type: Int) : Fragment() {

    var adapter = orderSentFraRecAdapter()
    var carList = arrayOf("car1", "car2", "car3")
    var carList2 = arrayListOf("c1", "c2", "c1", "c2", "c3")
    lateinit var refundDialog: MyDialog
    lateinit var sendMessageDialog: MyDialog
    lateinit var callSellerDialog: MyDialog
    lateinit var deleteOrderDialog: MyDialog

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
            var view = LayoutInflater.from(activity).inflate(R.layout.item_order_sent, null)
            return orderSentFraRecHolder(view)
        }

        override fun onBind(holder: RecyclerView.ViewHolder?, position: Int, data: String?) {
            if (fromType == 1) { //买家
                when (type) {
                    1 -> {
                        view?.text_state?.text = "等待买家付款"
                        holder?.itemView?.rela_btn_refund_11?.visibility = View.VISIBLE

                        holder?.itemView?.item_btn_call_seller?.setOnClickListener { //联系卖家
                            var builder = MyDialog.Companion.Builder(activity, null, "确认联系卖家？", "确认", "取消")
                            builder.yesClickListener = DialogInterface.OnClickListener { dialogInterface, i -> }
                            builder.noClickListener = DialogInterface.OnClickListener { dialogInterface, i -> callSellerDialog.dismiss() }
                            callSellerDialog = builder.create()
                            callSellerDialog.show()
                        }
                    }
                    2 -> { //待发货

                        holder?.itemView?.rela_btn_refund_12?.visibility = View.VISIBLE
                        view?.text_state?.text = "待发货"

                        holder?.itemView?.item_btn_refund?.setOnClickListener { //申请退款
                            var builder = MyDialog.Companion.Builder(activity, "申请退款", "确认提交后，商家客服会与您联系！", "确认", "取消")
                            builder.yesClickListener = DialogInterface.OnClickListener { dialogInterface, i -> }
                            builder.noClickListener = DialogInterface.OnClickListener { dialogInterface, i -> refundDialog.dismiss() }
                            refundDialog = builder.create()
                            refundDialog.show()
                        }
                        holder?.itemView?.item_btn_send_message?.setOnClickListener { //提醒卖家发货
                            var builder = MyDialog.Companion.Builder(activity, null, "您今天已经提醒发货了，明天再来哦！", "确认", "取消")
                            builder.yesClickListener = DialogInterface.OnClickListener { dialogInterface, i -> }
                            builder.noClickListener = DialogInterface.OnClickListener { dialogInterface, i -> sendMessageDialog.dismiss() }
                            sendMessageDialog = builder.create()
                            sendMessageDialog.show()
                        }
                    }
                    4 -> { //待评价
                        holder?.itemView?.rela_btn_refund_14?.visibility = View.VISIBLE
                        view?.text_state?.text = "待评价"
                        holder?.itemView?.item_btn_delete_order?.setOnClickListener { //删除订单
                            var builder = MyDialog.Companion.Builder(activity, "确认删除订单？", "删除之后不可恢复！", "确认", "取消")
                            builder.yesClickListener = DialogInterface.OnClickListener { dialogInterface, i -> }
                            builder.noClickListener = DialogInterface.OnClickListener { dialogInterface, i -> deleteOrderDialog.dismiss() }
                            deleteOrderDialog = builder.create()
                            deleteOrderDialog.show()
                        }

                        holder?.itemView?.item_btn_evaluate?.setOnClickListener {
                            startActivity(Intent(activity, OrderEvaluateActivity::class.java))
                        }
                    }
                }
            } else { //卖家
                var btnStr = ""
                var textStr = ""
                when (type) {
                    0 -> {
                        btnStr = "查看物流"
                        textStr = "已发货"
                    }
                    1 -> {
                        btnStr = "取消该订单"
                        textStr = "等待买家付款"
                    }
                    2 -> {
                        btnStr = "发货"
                        textStr = "待发货"
                    }
                    3 -> {
                        btnStr = "查看物流"
                        textStr = "已发货"
                    }
                    4 -> {
                        btnStr = "买家未评价"
                        textStr = "交易成功"
                    }
                }
                view?.item_btn1?.text = btnStr
                view?.text_state?.text = textStr
                holder?.itemView?.rela_btn_02?.visibility = View.VISIBLE

                holder?.itemView?.item_btn1?.setOnClickListener {
                    when (type) {
                        2 -> { //发货
                            holder?.itemView?.rela_btn_02?.visibility = View.GONE
                            holder.itemView?.rela_radiogroup_02_after?.visibility = View.VISIBLE

                            holder?.itemView?.radiobtn3?.setOnClickListener { //点击取消发货，radiogruop小时
                                holder?.itemView?.rela_btn_02?.visibility = View.VISIBLE
                                holder.itemView?.rela_radiogroup_02_after?.visibility = View.GONE
                                holder.itemView?.radiobtn3?.isChecked = false
                                holder?.itemView?.recy?.visibility = View.GONE
                            }
                            holder?.itemView?.radiobtn1?.setOnClickListener { //点击选择抢单货车
                                holder?.itemView?.recy?.visibility = View.VISIBLE
                                holder.itemView?.recy?.layoutManager = LinearLayoutManager(activity)
                                holder.itemView?.recy?.adapter = carListRec().setData(carList2)
                            }
                        }
                        3 -> { //查看物流
                            startActivity(Intent(activity, LookLogisticsActivity::class.java))
                        }
                    }
                }
            }
        }

        inner class orderSentFraRecHolder(view: View) : RecyclerView.ViewHolder(view) {

        }
    }


    inner class carListRec : BaseRecyclerAdapte<String>() {
        override fun onCreate(parent: ViewGroup?, viewType: Int, inflater: LayoutInflater?): RecyclerView.ViewHolder? {
            var view = inflater!!.inflate(R.layout.item_order_sent_carlist_item, null)
            return MyHolder(view)
        }

        override fun onBind(holder: RecyclerView.ViewHolder?, position: Int, data: String?) {

        }

        inner class MyHolder(view: View) : RecyclerView.ViewHolder(view) {

        }
    }

}