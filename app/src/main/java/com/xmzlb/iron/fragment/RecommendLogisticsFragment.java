package com.xmzlb.iron.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.hedgehog.ratingbar.RatingBar;
import com.xmzlb.iron.R;

/**
 * 推荐物流
 */
public class RecommendLogisticsFragment extends Fragment {


    private View mView;
    private ListView mLv;
    LayoutInflater inflater;

    public RecommendLogisticsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_recommend_logistics, container, false);
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
            View view = inflater.inflate(R.layout.layout_recommend_logistics, null);
            RatingBar ratingbar = (RatingBar) view.findViewById(R.id.carFraRatingbar);
            ratingbar.setStar(4);
            return view;
        }
    }

}
