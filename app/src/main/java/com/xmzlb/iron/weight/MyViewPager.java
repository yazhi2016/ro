package com.xmzlb.iron.weight;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by zyz on 2016/5/17 0017.
 * QQ:344100167
 */
public class MyViewPager extends ViewPager{
    boolean canScroll = true;

    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setCanScroll(boolean canScroll) {
        this.canScroll = canScroll;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(canScroll) {
            return super.onInterceptTouchEvent(ev);
        } else {
            return false;
        }
    }
}
