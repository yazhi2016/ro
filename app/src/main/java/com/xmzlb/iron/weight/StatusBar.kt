package com.xmzlb.iron.weight

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.xmzlb.iron.R
import kotlinx.android.synthetic.main.view_status_bar.view.*

/**
 * Created by zyz on 2016/6/14 0014.
 * QQ:344100167
 *
 */
class StatusBar : LinearLayout {

    constructor(context: Context) : super(context) {

    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.view_status_bar, this)
        text_status1.setTextColor(resources.getColor(R.color.green))
        text_status_circle1.setTextColor(resources.getColor(R.color.green))
    }

    fun changeStatus(status: Int = 1) {
        when (status) {

            1 -> {
                text_status1.setTextColor(resources.getColor(R.color.green))
                setBack(text_status_circle1)
            }
            2 -> {
                text_status1.setTextColor(resources.getColor(R.color.green))
                setBack(text_status_circle1)
                text_status2.setTextColor(resources.getColor(R.color.green))
                setBack(text_status_circle2)
            }
            3 -> {
                text_status1.setTextColor(resources.getColor(R.color.green))
                setBack(text_status_circle1)
                text_status2.setTextColor(resources.getColor(R.color.green))
                setBack(text_status_circle2)
                text_status3.setTextColor(resources.getColor(R.color.green))
                setBack(text_status_circle3)
            }
            4 -> {
                text_status1.setTextColor(resources.getColor(R.color.green))
                setBack(text_status_circle1)
                text_status2.setTextColor(resources.getColor(R.color.green))
                setBack(text_status_circle2)
                text_status3.setTextColor(resources.getColor(R.color.green))
                setBack(text_status_circle3)
                text_status4.setTextColor(resources.getColor(R.color.green))
                setBack(text_status_circle4)
            }
            5 -> {
                text_status1.setTextColor(resources.getColor(R.color.green))
                setBack(text_status_circle1)
                text_status2.setTextColor(resources.getColor(R.color.green))
                setBack(text_status_circle2)
                text_status3.setTextColor(resources.getColor(R.color.green))
                setBack(text_status_circle3)
                text_status4.setTextColor(resources.getColor(R.color.green))
                setBack(text_status_circle4)
                text_status5.setTextColor(resources.getColor(R.color.green))
                setBack(text_status_circle5)
            }
        }
    }

    private fun setBack(text:TextView) {
        if (Build.VERSION.SDK_INT >= 16) {
            text.background = resources.getDrawable(R.drawable.circle_green)
        } else {
            text.setBackgroundDrawable(resources.getDrawable(R.drawable.circle_green))
        }
    }
}