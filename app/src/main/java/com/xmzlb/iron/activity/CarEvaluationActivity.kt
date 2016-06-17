package com.xmzlb.iron.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.xmzlb.iron.R
import kotlinx.android.synthetic.main.activity_car_evaluation.*
import kotlinx.android.synthetic.main.topbar.*

/**
 * 货车评价
 */
class CarEvaluationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_evaluation)

        topbar_text.text = "货车评价"
        topbar_btn_back.setOnClickListener { finish() }

        star.setStar(3f)
        star_big.setOnRatingChangeListener {
            i ->
            when (i) {
                1 -> text_evaluation.text = "非常不满意，各方面都很差"
                2 -> text_evaluation.text = "不满意，比较差"
                3 -> text_evaluation.text = "一般，需要改善"
                4 -> text_evaluation.text = "较满意，但仍可改善"
                5 -> text_evaluation.text = "非常满意，无可挑剔"
            }
        }
    }
}
