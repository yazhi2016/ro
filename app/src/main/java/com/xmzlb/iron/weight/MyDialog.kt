package com.xmzlb.iron.weight

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.xmzlb.iron.R

/**
 * Created by zyz on 2016/5/23 0023.
 * QQ:344100167
 *
 */

class MyDialog(context: Context, theme: Int) : Dialog(context, theme) {

    companion object {

        //type: 0 正常的title（默认），message；1，输入价格；2，输入物流
        public class Builder(val context: Context, var title: String?, var message: String ?, var yesText: String ?, var noText: String ?, val type:Int = 0) {
            var contentview: View ? = null
            var yesClickListener: DialogInterface.OnClickListener ? = null
            var noClickListener: DialogInterface.OnClickListener ? = null

            fun setContentView(view: View): Builder {
                this.contentview = view
                return this
            }

            fun setYesClickListener(yesClickListener: DialogInterface.OnClickListener): Builder {
                this.yesClickListener = yesClickListener
                return this
            }

            fun setNoClickListener(noClickListener: DialogInterface.OnClickListener): Builder {
                this.noClickListener = noClickListener
                return this
            }

            fun create(): MyDialog {
                val view = LayoutInflater.from(context).inflate(R.layout.layout_mydialog, null)
                val dialog = MyDialog(context, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen)
                dialog.addContentView(view, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
                var titleView = view.findViewById(R.id.title) as TextView
                if (title == null) {
                    titleView.visibility = View.GONE
                } else {
                    titleView.visibility = View.VISIBLE
                    titleView.text = title
                }
                var text_message = view.findViewById(R.id.message) as TextView
                var linear_price = view.findViewById(R.id.linear_price) as LinearLayout
                var linear_logistics = view.findViewById(R.id.linear_logistics) as LinearLayout
                when(type) {
                    0 -> { //默认模式
                        text_message.visibility = View.VISIBLE
                        linear_price.visibility = View.GONE
                        linear_logistics.visibility = View.GONE
                        text_message.text = message
                    }
                    1 -> { //价格模式
                        text_message.visibility = View.GONE
                        linear_price.visibility = View.VISIBLE
                        linear_logistics.visibility = View.GONE
                    }
                    2 -> { //填写物流信息模式
                        text_message.visibility = View.GONE
                        linear_price.visibility = View.GONE
                        linear_logistics.visibility = View.VISIBLE
                    }
                }
                var btn_yes = view.findViewById(R.id.btn_yes) as Button
                btn_yes.text = yesText
                btn_yes.setOnClickListener { yesClickListener?.onClick(dialog, BUTTON_POSITIVE) }
                var btn_no = view.findViewById(R.id.btn_no) as Button
                btn_no.text = noText
                btn_no.setOnClickListener { noClickListener?.onClick(dialog, BUTTON_POSITIVE) }
                dialog.setContentView(view)
                return dialog
            }
        }
    }
}