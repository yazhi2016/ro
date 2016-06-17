package com.xmzlb.iron.activity

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xmzlb.iron.R
import com.xmzlb.iron.base.BaseRecyclerAdapte
import com.xmzlb.iron.weight.MyDialog
import kotlinx.android.synthetic.main.activity_car_detail.*
import kotlinx.android.synthetic.main.include_itembar.*
import kotlinx.android.synthetic.main.topbar.*

/**
 * 货车详情
 */
class CarDetailActivity : AppCompatActivity() {

    var list = arrayListOf("1", "1", "1", "1")
    lateinit var myDialog: MyDialog
    lateinit var myDialog2: MyDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_detail)


        topbar_text.text = "货车详情"
        topbar_btn_back.setOnClickListener { finish() }

        carDetailRatingbar.setStar(3f)
        carDetailRec.layoutManager = GridLayoutManager(this, 4)
        carDetailRec.adapter = recAdapter().setData(list)

        itembar_text.text = "货车信息"

        btn_comfirm.setOnClickListener {
            var builder = MyDialog.Companion.Builder(this, "温馨提示", "谨慎选择，低价格并不是最好的哦！", "确认", "取消")
            builder.yesClickListener = DialogInterface.OnClickListener { dialogInterface, i ->
                myDialog.dismiss()
                var builder2 = MyDialog.Companion.Builder(this, null, "确认发货？", "确认", "取消")
                builder2.yesClickListener = DialogInterface.OnClickListener { dialogInterface, i -> myDialog2.dismiss() }
                builder2.noClickListener = DialogInterface.OnClickListener { dialogInterface, i -> myDialog2.dismiss() }
                myDialog2 = builder2.create()
                myDialog2.show()
            }
            builder.noClickListener = DialogInterface.OnClickListener { dialogInterface, i -> myDialog.dismiss() }
            myDialog = builder.create()
            myDialog.show()
        }
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
