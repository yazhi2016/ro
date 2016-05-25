package com.xmzlb.iron.model

/**
 * Created by zyz on 2016/5/17 0017.
 * QQ:344100167
 */
class City {

    /**
     * city_id : 1781
     * centerx : 102.224653
     * district_online : 1
     * centery : 31.899413
     * name : 阿坝州
     * province : 四川
     * zone_online : 1
     * pinyin : abazhou
     */

    var allcity: List<AllcityBean>? = null

    class AllcityBean {
        var name: String? = null
        var pinyin: String? = null
    }
}
