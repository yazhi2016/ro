package com.xmzlb.iron.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xmzlb.iron.R;
import com.xmzlb.iron.base.BaseRecyclerAdapte;

/**
 * Created by zyz on 2016/5/19 0019.
 * QQ:344100167
 */
public class ProductFragmentAdapter extends BaseRecyclerAdapte<String> {

    Context context;

    public ProductFragmentAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType, LayoutInflater inflater) {
        View inflate = inflater.inflate(R.layout.layout_product, null);
        return new MyHolder(inflate);
    }

    @Override
    public void onBind(RecyclerView.ViewHolder holder, int position, String data) {
    }

    class MyHolder extends RecyclerView.ViewHolder {

        public MyHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "222", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
