package com.xmzlb.iron.fragment

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
import kotlinx.android.synthetic.main.fragment_allorder.*

/**
 * Created by zyz on 2016/5/20 0020.
 * QQ:344100167
 *
 */

open class AllOrderFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_allorder, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        allOrdFraRec.layoutManager = LinearLayoutManager(activity)
        allOrdFraRec.adapter = MyAdapter().setData(GlobalParames.getList())
    }

    inner class MyAdapter : BaseRecyclerAdapte<String>() {
        override fun onCreate(parent: ViewGroup?, viewType: Int, inflater: LayoutInflater?): RecyclerView.ViewHolder? {
            val view = LayoutInflater.from(activity).inflate(R.layout.item_allorderfrarec, null)
            return MyHolder(view)
        }

        override fun onBind(holder: RecyclerView.ViewHolder?, position: Int, data: String?) {
        }

        inner class MyHolder(view : View) : RecyclerView.ViewHolder(view) {

        }
    }
}