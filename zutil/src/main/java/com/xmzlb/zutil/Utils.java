package com.xmzlb.zutil;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by zyz on 2016/4/19 0019.
 * QQ:344100167
 */
public class Utils {

    /**
     * 跳转到拨号界面
     * @param context
     * @param number 需要显示的电话
     */
    public static void startCallActivity(Context context, String number) {
        Intent intentPhone = new Intent();
        intentPhone.setAction(Intent.ACTION_DIAL); // android.intent.action.DIAL
        intentPhone.setData(Uri.parse("tel:" + number));
        context.startActivity(intentPhone);
    }

}
