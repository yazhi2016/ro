package com.xmzlb.iron.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by zyz on 2016/5/19 0019.
 * QQ:344100167
 */
public abstract class BaseRecyclerAdapte<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    onItemClickListener mOnItemClickListener;

    ArrayList<T> mData = new ArrayList<>();

    public interface onItemClickListener{
        void onClick(View view, int position);
    }

    public void setOnItemClickListener(onItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return onCreate(parent, viewType, inflater);
    }

    //抽象方法，返回的holder传给oncreateViewholder
    public abstract RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType, LayoutInflater inflater);

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        T data = mData.get(position);
        onBind(holder, position, data);
        if(mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(holder.itemView, position);
                }
            });
        }
    }

    //抽象方法，重写后就再onbindviewHodler里执行，一般用于数据绑定等
    public abstract void onBind(final RecyclerView.ViewHolder holder, final int position, T data);

    public BaseRecyclerAdapte<T> setData(ArrayList<T> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
        return this;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
