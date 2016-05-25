package com.xmzlb.zutil.weight;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.xmzlb.zutil.R;

/**
 * Created by zyz on 2016/4/19
 * QQ:344100167
 * 广告轮播图片指示器
 */

public class ViewPagerIndicator extends View {
    private static int CX;
    private static int CY;
    private static float radiusSize = 20;
    //直径
    private float size = 7;
    //间距
    private float distance = 10;
    private Paint paint;
    private Paint paint2;
    private Paint paint3;
    private int offset;
    private int layout_position;
    private int indicatorCount;
    int num = 2;
    private int mOtherColor;
    private int mCurrentColor;

    @Override
    protected void onDraw(Canvas canvas) {
        if (CX == 0) {
            int width = getWidth();
            //调整Y轴高度
            CY = getHeight() / 2;
            switch (layout_position) {
                case 0:// 居中
                    CX = (int) (width / 2 - (indicatorCount - 1) * 1.5 * distance);
                    break;
                case 1:// 居左
                    CX = (int) (2 * radiusSize);
                    break;
                case 2:// 居右
                    CX = (int) (width - indicatorCount * 3 * radiusSize);
                    break;

                default:
                    break;
            }
        }
        for (int i = 0; i < indicatorCount; i++) {
            canvas.drawCircle(CX + i * 3 * distance, CY, radiusSize, paint);
        }

        canvas.drawCircle(CX + offset, CY, radiusSize, paint3);
    }

    public void move(float percent, int position) {
//		offset = (int) ((percent + position) * 3 * juli);
        offset = (int) ((position) * 3 * distance);
        invalidate();
    }

    private void initPaint() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //其他圆颜色
        mOtherColor = Color.parseColor("#A7A7A7");
        paint.setColor(mOtherColor);
        paint.setTextSize(26);
        paint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        //当前圆颜色
        mCurrentColor = Color.parseColor("#AA8D31");
        paint3.setColor(mCurrentColor);
        paint3.setTextSize(26);
//		paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
//		paint2.setColor(Color.WHITE);
//		paint2.setStyle(Style.STROKE);// 绘制空心
//		paint2.setStrokeWidth(2);
//		paint2.setTextSize(26);
    }

    /**
     * @param num      数量
     * @param size     圆的直径
     * @param distance 圆的间距
     */
    public void changeNum(int num, float size, float distance) {
        this.num = num;
        this.indicatorCount = num;
        this.size = size;
        this.distance = distance;
        invalidate();
    }

    /**
     * 设定圆的颜色(传入int类型的color值)
     *
     * @param currentColor 当前圆的颜色
     * @param otherColor   其他圆的颜色
     */
    public void changeColor(int currentColor, int otherColor) {
        mCurrentColor = currentColor;
        mOtherColor = otherColor;
        invalidate();
    }

    /**
     * 设定圆的颜色(传入String类型的color值)
     *
     * @param currentColor 当前圆的颜色
     * @param otherColor   其他圆的颜色
     */
    public void changeColor(String currentColor, String otherColor) {
        mCurrentColor = Color.parseColor(currentColor);
        mOtherColor = Color.parseColor(otherColor);
        invalidate();
    }

    public ViewPagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs,
                R.styleable.ViewPagerIndicator);
        radiusSize = array.getDimension(
                //半径
                R.styleable.ViewPagerIndicator_radiusSize, size);
        layout_position = array.getInt(R.styleable.ViewPagerIndicator_layout_position, 0);
        //个数
        indicatorCount = array.getInteger(R.styleable.ViewPagerIndicator_indicatorCount, num);
        array.recycle();// 释放内存
        initPaint();
    }

}
