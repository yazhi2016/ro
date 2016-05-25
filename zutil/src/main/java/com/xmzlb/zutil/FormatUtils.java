package com.xmzlb.zutil;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zyz on 2016/4/19 0019.
 * QQ:344100167
 * 正则验证相关工具
 */
public class FormatUtils {
    /**
     * 验证手机号码
     *
     * @param 手机号
     * @return
     */
//    public static boolean checkMobileNumber(String mobileNumber) {
//        boolean flag = false;
//        try {
//            Pattern regex = Pattern
//                    .compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
//            Matcher matcher = regex.matcher(mobileNumber);
//            flag = matcher.matches();
//        } catch (Exception e) {
//            flag = false;
//        }
//        return flag;
//    }

    /**
     * 验证手机号码
     * @param 手机号
     * @return
     */
    public static boolean checkMobileNumber(String number) {
        // 13\\d{9} 指前两位为1和3，后面跟任意9位；
        // 14[57]\\d{8} 指前两位为1和4，第三位为5或7，后面跟任意8位；
        String telRegex = "13\\d{9}|14[57]\\d{8}|15[012356789]\\d{8}|18[01256789]\\d{8}|17[0678]\\d{8}";
        if (TextUtils.isEmpty(number)) return false;
        else return number.matches(telRegex);
    }
}
