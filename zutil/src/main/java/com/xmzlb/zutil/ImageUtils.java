package com.xmzlb.zutil;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by zyz on 2016/4/19 0019.
 * QQ:344100167
 * 图片相关工具
 */
public class ImageUtils {

    /**
     * 将图片宽度设为屏幕同宽，高度等比放大，imageview要要设置scaleType="centerCrop"
     *
     * @param drawable  要显示的图片
     * @param imageview 显示图片的控件
     */
    public static void enlargeImgHeight(Drawable drawable, ImageView imageview) {
        int drawableHeight = drawable.getMinimumHeight();
        int drawableWidth = drawable.getMinimumWidth();
        int width = imageview.getWidth();
        float v = (float) width / drawableWidth;
        int height = (int) (v * drawableHeight);
//		if (height > drawableHeight) { //如果图片高度小于屏幕，则设置为图片高度
//            height = drawableHeight;
//        }
        imageview.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height));
        imageview.setImageDrawable(drawable);
    }
}
