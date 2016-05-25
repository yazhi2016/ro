package com.xmzlb.iron.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.xmzlb.iron.R;

/**
 * 关联商品
 */
public class ConnectProductFragment extends Fragment {

    private View mView;
    private ListView mLv;
    LayoutInflater inflater;

    public ConnectProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(mView == null) {
            mView = inflater.inflate(R.layout.fragment_connect_product, container, false);
            this.inflater = inflater;
            mLv = (ListView) mView.findViewById(R.id.listview);
            mLv.setAdapter(new lvAdapter());
        }
        return mView;
    }

    class lvAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = inflater.inflate(R.layout.layout_connect_product, null);
            return view;
        }
    }
}
