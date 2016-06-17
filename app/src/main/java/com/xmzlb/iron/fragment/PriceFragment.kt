package com.xmzlb.iron.fragment


import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.PopupWindow
import android.widget.Toast
import com.wx.wheelview.adapter.ArrayWheelAdapter
import com.wx.wheelview.adapter.BaseWheelAdapter
import com.wx.wheelview.widget.WheelView
import com.xmzlb.iron.R
import com.xmzlb.iron.weight.MyDialog
import kotlinx.android.synthetic.main.fragment_price.*
import kotlinx.android.synthetic.main.pop_choosedate.view.*
import kotlinx.android.synthetic.main.topbar.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * 首页 行情
 */
class PriceFragment : Fragment(), View.OnClickListener {

    private var mView: View? = null
    lateinit internal var inflater: LayoutInflater
    lateinit private var mChoosedcate: PopupWindow
    private var format: SimpleDateFormat? = null
    lateinit internal var pop_choosedcate: View

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        if (mView == null) {
            mView = inflater!!.inflate(R.layout.fragment_price, container, false)
            this.inflater = inflater
        }
        return mView
    }

    private val test: String
        get() {
            var str: String = "123123"
            return str
        }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refreshLayout.setColorSchemeColors(Color.parseColor("#00B700"))
        priceLv.adapter = lvAdapter()
        chooseDate.setOnClickListener(this)
        pop_choosedcate = inflater.inflate(R.layout.pop_choosedate, null)
        pop_choosedcate.comfirm.setOnClickListener(this)
        pop_choosedcate.rela_year.setOnClickListener(this)
        pop_choosedcate.rela_month.setOnClickListener(this)
        pop_choosedcate.calendar.isSelectMore = false
        format = SimpleDateFormat("yyyy-MM-dd")
        var str: String = test
        str.toString()
        pop_choosedcate.calendar.setOnItemClickListener { selectedStartDate, selectedEndDate, downDate ->
            if (!pop_choosedcate.calendar.isSelectMore) {
                Toast.makeText(activity.applicationContext, format!!.format(downDate), Toast.LENGTH_SHORT).show()
            }
        }
        mChoosedcate = PopupWindow(pop_choosedcate, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true)
        // 设置点击窗体以外区域关闭窗体
        val b = BitmapDrawable()
        mChoosedcate.setBackgroundDrawable(b)
        mChoosedcate.setOnDismissListener { }

        topbar_btn_share.setOnClickListener {
            var builder = MyDialog.Companion.Builder(activity, null, "test message1", "yes1", "no1")
            builder.yesClickListener = DialogInterface.OnClickListener { dialogInterface, i -> }
            builder.noClickListener = DialogInterface.OnClickListener { dialogInterface, i -> }
            builder.create().show()
        }
    }

    internal var list = ArrayList<Fragment>()

    override fun onClick(v: View) {
        when (v.id) {
            R.id.chooseDate -> mChoosedcate.showAsDropDown(rela_choosedate)
            R.id.comfirm -> {
            }
            R.id.rela_year -> initDateDialog(0)
            R.id.rela_month -> initDateDialog(1)
            else -> {
            }
        }
    }

    private fun initDateDialog(mode: Int) {
        val instance = Calendar.getInstance()
        instance.time = Date()
        if (mode == 0) {
            val view = inflater.inflate(R.layout.dailog_dateyear, null)
            val wheelView = view.findViewById(R.id.wheelview) as WheelView<Any>
            wheelView.setWheelAdapter(ArrayWheelAdapter(activity) as BaseWheelAdapter<Any>) // 文本数据源
            val year = instance.get(Calendar.YEAR)
            val list = ArrayList<String>()
            for (i in 0..9) {
                val num: Int
                num = year - i
                list.add(num.toString())
            }
            wheelView.setWheelData(list as List<String>)
            wheelView.selection = 0
            wheelView.skin = WheelView.Skin.Holo
            val builder1 = AlertDialog.Builder(activity).setView(view)
            builder1.show()
        } else {
            val view2 = inflater.inflate(R.layout.dailog_dateyear, null)
            val mWheelView = view2.findViewById(R.id.wheelview) as WheelView<Any>
            mWheelView.setWheelAdapter(ArrayWheelAdapter(activity)as BaseWheelAdapter<Any>) // 文本数据源
            val month = instance.get(Calendar.MONTH)
            val monthList = arrayOf("一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月")
            val monthLists = Arrays.asList(*monthList)
            mWheelView.setWheelData(monthLists as List<String>)
            mWheelView.selection = month
            mWheelView.skin = WheelView.Skin.Holo
            val builder2 = AlertDialog.Builder(activity).setView(view2)
            builder2.show()
        }

    }

    internal inner class lvAdapter : BaseAdapter() {

        override fun getCount(): Int {
            return 130
        }

        override fun getItem(position: Int): Any? {
            return null
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
            var view = LayoutInflater.from(activity).inflate(R.layout.layout_pricefra, null)
            return view
        }
    }
}
