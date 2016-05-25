package com.xmzlb.iron.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.xmzlb.iron.R
import kotlinx.android.synthetic.main.activity_logistics_assess.*
import kotlinx.android.synthetic.main.topbar.*

/**
 * 物流评价
 */
class LogisticsAssessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logistics_assess)

        topbar_btn_back.setOnClickListener { finish() }

        scrollview.smoothScrollTo(0, 0)
    }
}
