package com.xmzlb.iron.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.xmzlb.iron.R
import kotlinx.android.synthetic.main.fragment_product.*


/**
 * 商品动态
 */
class ProductFragment : Fragment() {

    lateinit internal var inflater: LayoutInflater
    lateinit internal var strs:String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.inflater = LayoutInflater.from(view.context)
        productLv.adapter = lvAdapter()

//        var adapter = ProductFragmentAdapter(activity)
//        adapter.setData(GlobalParames.getList())
//        product_recycler.layoutManager = LinearLayoutManager(activity)
//        product_recycler.adapter = adapter
    }

    internal inner class lvAdapter : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
            return inflater.inflate(R.layout.layout_product, null)
        }

        override fun getCount(): Int {
            return 10
        }

        override fun getItem(position: Int): Any? {
            return null
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

    }
}// Required empty public constructor
