package com.xmzlb.iron.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.xmzlb.iron.R;

/**
 * 推荐商铺
 */
public class RecommendShopFragment extends Fragment {


    private View view;
    private ListView mLv;
    LayoutInflater inflater;

    public RecommendShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(view == null) {
            view = inflater.inflate(R.layout.fragment_recommend_shop, container, false);
            this.inflater = inflater;
            mLv = (ListView) view.findViewById(R.id.listview);
            mLv.setAdapter(new lvAdapter());
        }
        return view;
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
            View view = inflater.inflate(R.layout.layout_recommendshop, null);
            TextView level =  (TextView) view.findViewById(R.id.level);
            if(position == 2) {
                level.setCompoundDrawables(null, null, null, null);
            }
            return view;
        }
    }

}
