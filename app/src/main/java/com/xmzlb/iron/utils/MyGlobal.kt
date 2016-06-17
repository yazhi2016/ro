package com.xmzlb.iron.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import java.util.*

/**
 * Created by zyz on 2016/5/17 0017.
 * QQ:344100167
 */
object MyGlobal {
    var myList = ArrayList<String>()

    fun getList(): ArrayList<String> {
        for (i in 0..4) {
            myList.add("123")
        }
        return myList
    }

    fun myLog(message : String) {
        Log.e("==", message)
    }

    fun myToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}
