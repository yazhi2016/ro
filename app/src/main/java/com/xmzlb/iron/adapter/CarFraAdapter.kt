package com.xmzlb.iron.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.xmzlb.iron.R
import com.xmzlb.iron.base.BaseRecyclerAdapte

/**
 * Created by zyz on 2016/5/19 0019.
 * QQ:344100167
 */
class CarFraAdapter(internal var context:

                    Context) : BaseRecyclerAdapte<String>() {

    override fun onCreate(parent: ViewGroup, viewType: Int, inflater: LayoutInflater): RecyclerView.ViewHolder {
        val inflate = inflater.inflate(R.layout.layout_recommend_logistics, null)
        return MyHolder(inflate)
    }

    override fun onBind(holder: RecyclerView.ViewHolder, position: Int, data: String) {
    }

    internal inner class MyHolder(itemView: View)//            itemView.setOnClickListener(new View.OnClickListener() {
    //                @Override
    //                public void onClick(View v) {
    //                    Toast.makeText(context, "222", Toast.LENGTH_SHORT).show();
    //                }
    //            });
    : RecyclerView.ViewHolder(itemView)
}
