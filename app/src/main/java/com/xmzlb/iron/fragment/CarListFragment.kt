package com.xmzlb.iron.fragment

/**
 * Created by zyz on 2016/5/20 0020.
 * QQ:344100167
 *
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
import com.xmzlb.iron.utils.MyGlobal
import kotlinx.android.synthetic.main.fragment_carlist.*
import kotlinx.android.synthetic.main.layout_recommend_logistics.view.*

/**
 * 首页-运输-货车列表
 */
open class CarListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_carlist , container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        carFraRec.layoutManager = LinearLayoutManager(activity)
        carFraRec.adapter = RecAdapter().setData(MyGlobal.getList())

    }

    inner class RecAdapter : BaseRecyclerAdapte<String>() {
        override fun onCreate(parent: ViewGroup?, viewType: Int, inflater: LayoutInflater?): RecyclerView.ViewHolder? {
            val view = LayoutInflater.from(activity).inflate(R.layout.layout_recommend_logistics, null);
            view.carFraRatingbar.setStar(4.toFloat())
            return MyHolder(view);
        }

        override fun onBind(holder: RecyclerView.ViewHolder?, position: Int, data: String?) {
        }

        inner class MyHolder(view:View) : RecyclerView.ViewHolder(view) {

        }

    }

}