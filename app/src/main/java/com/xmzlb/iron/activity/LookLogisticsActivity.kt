package com.xmzlb.iron.activity

import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xmzlb.iron.R
import com.xmzlb.iron.base.BaseRecyclerAdapte
import com.xmzlb.iron.utils.GlobalParames
import com.xmzlb.iron.weight.MyDialog
import kotlinx.android.synthetic.main.activity_look_logistics.*
import kotlinx.android.synthetic.main.item_rec_looklog.view.*
import kotlinx.android.synthetic.main.topbar.*

/**
 * 查看物流
 */
class LookLogisticsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_look_logistics)

        topbar_text.text = "查看物流"
        topbar_btn_back.setOnClickListener { finish() }

        lookLogfraRec.layoutManager = LinearLayoutManager(this)
        lookLogfraRec.adapter = RecAdapter().setData(GlobalParames.getList())

        addLogistics.setOnClickListener {
            var builder = MyDialog.Companion.Builder(this, "添加物流", null, "确认", "取消", 2)
            builder.yesClickListener = DialogInterface.OnClickListener { dialogInterface, i -> }
            builder.noClickListener = DialogInterface.OnClickListener { dialogInterface, i -> }
            builder.create().show()
        }
    }

    inner class RecAdapter : BaseRecyclerAdapte<String>() {
        override fun onCreate(parent: ViewGroup?, viewType: Int, inflater: LayoutInflater?): RecyclerView.ViewHolder? {
            var view = layoutInflater.inflate(R.layout.item_rec_looklog, null)
            return MyHolder(view)
        }

        override fun onBind(holder: RecyclerView.ViewHolder?, position: Int, data: String?) {
            if (position == 0) {
                holder?.itemView?.img_circle?.setImageResource(R.drawable.circle)
                holder?.itemView?.message?.setTextColor(Color.parseColor("#00B700"))
                holder?.itemView?.time?.setTextColor(Color.parseColor("#00B700"))
            } else {
                holder?.itemView?.img_circle?.setImageResource(R.drawable.circlenosolid)
                holder?.itemView?.message?.setTextColor(Color.parseColor("#737373"))
                holder?.itemView?.time?.setTextColor(Color.parseColor("#737373"))
            }
        }

        inner class MyHolder(view: View) : RecyclerView.ViewHolder(view) {

        }

    }
}
