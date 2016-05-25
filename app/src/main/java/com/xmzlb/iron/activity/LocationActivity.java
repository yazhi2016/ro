package com.xmzlb.iron.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.xmzlb.iron.R;
import com.xmzlb.iron.base.BaseActivity;
import com.xmzlb.iron.model.City;
import com.xmzlb.iron.weight.LetterSideBar;
import com.xmzlb.zutil.GsonUtils;
import com.xmzlb.zutil.weight.MyGridView;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 定位界面
 */
public class LocationActivity extends BaseActivity {

    private LetterSideBar mLetterSideBar;
    /**
     * 所有市
     */
    ArrayList<City.AllcityBean> citiesList = new ArrayList<>();

    String nowCity = "定位中...";

    int s = 19;
    private ListView mListview;
    private lvAdapter mLvAdapter;
    private LayoutInflater mInflater;

    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明mLocationOption对象
    public AMapLocationClientOption mLocationOption = null;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation amapLocation) {
            if (amapLocation != null) {
                if (amapLocation.getErrorCode() == 0) {
                    //定位成功回调信息，设置相关消息
                    amapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                    amapLocation.getLatitude();//获取纬度
                    amapLocation.getLongitude();//获取经度
                    amapLocation.getAccuracy();//获取精度信息
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date(amapLocation.getTime());
                    df.format(date);//定位时间
                    amapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                    amapLocation.getCountry();//国家信息
                    amapLocation.getProvince();//省信息
                    String city = amapLocation.getCity();//城市信息
                    amapLocation.getDistrict();//城区信息
                    amapLocation.getStreet();//街道信息
                    amapLocation.getStreetNum();//街道门牌号信息
                    amapLocation.getCityCode();//城市编码
                    amapLocation.getAdCode();//地区编码
                    amapLocation.getAoiName();//获取当前定位点的AOI信息
                    nowCity = city;
                    mGvAdapter_now.notifyDataSetChanged();
                    mLocationClient.stopLocation();//停止定位
                } else {
                    //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                    Log.e("AmapError", "location Error, ErrCode:"
                            + amapLocation.getErrorCode() + ", errInfo:"
                            + amapLocation.getErrorInfo());
                }
            }
        }
    };
    private GvAdapter mGvAdapter_now;

    private ListView lvSearch;
    private EditText edtLocation;

    ArrayList<String> searchList = new ArrayList<>();
    private SerchLvAdapter mSerchLvAdapter;
    private LinearLayout locationLinear;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        mInflater = getLayoutInflater();
        initViews();
        init();
        initEvents();


        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否只定位一次,默认为false
        mLocationOption.setOnceLocation(false);
        //设置是否强制刷新WIFI，默认为强制刷新
        mLocationOption.setWifiActiveScan(true);
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
    }

    protected void initViews() {
        image = (ImageView) findViewById(R.id.image); //搜索框图片
        edtLocation = (EditText) findViewById(R.id.edt_location);
        lvSearch = (ListView) findViewById(R.id.lv_search);
        mLetterSideBar = (LetterSideBar) findViewById(R.id.letterSideBar);
        mListview = (ListView) findViewById(R.id.listview);
        mLvAdapter = new lvAdapter();
        locationLinear = (LinearLayout) findViewById(R.id.location_linear);
        String string = "12";
        String see = string+ "123";
        new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        };
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void init() {
        mLetterSideBar.setOnLetterChangedListener(new LetterSideBar.OnLetterChangedListener() {

            @Override
            public void onTouchAction(int action) {
                switch (action) {
                    case MotionEvent.ACTION_DOWN: // 按下
//                        nowLetter.setVisibility(View.VISIBLE);
                        break;
                    case MotionEvent.ACTION_MOVE: // 滑动
                        break;
                    case MotionEvent.ACTION_UP: // 松开
//                        nowLetter.setVisibility(View.GONE);
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onLetterChanged(String letter) {
//                nowLetter.setText(letter);
                for (int i = 0; i < citiesList.size(); i++) {
                    String cityFirst = citiesList.get(i).getPinyin().substring(0, 1);
                    String lowerCase = letter.toLowerCase();
                    if (lowerCase.equals(cityFirst)) {
                        mListview.setSelection(i);
                        break;
                    }
                }
            }
        });

        initJsonData();

        //定位城市
        View nowCity = mInflater.inflate(R.layout.head_city, null);
        TextView nowText = (TextView) nowCity.findViewById(R.id.headText);
        nowText.setText("当前定位城市");
        MyGridView gv_nowcity = (MyGridView) nowCity.findViewById(R.id.gridview);
        //0定位城市，1最近访问城市，2热门城市
        mGvAdapter_now = new GvAdapter(0);
        gv_nowcity.setAdapter(mGvAdapter_now);
        //最近访问城市
        View recentCity = mInflater.inflate(R.layout.head_city, null);
        TextView recentText = (TextView) recentCity.findViewById(R.id.headText);
        recentText.setText("最近访问城市");
        MyGridView gv_recentcity = (MyGridView) recentCity.findViewById(R.id.gridview);
        GvAdapter gvAdapter_recent = new GvAdapter(1); //0定位城市，1最近访问城市，2热门城市
        gv_recentcity.setAdapter(gvAdapter_recent);
        //热门城市
        View hotCity = mInflater.inflate(R.layout.head_city, null);
        TextView hotText = (TextView) hotCity.findViewById(R.id.headText);
        hotCity.findViewById(R.id.empty).setVisibility(View.VISIBLE);
        hotText.setText("热门城市");
        MyGridView gv_hotcity = (MyGridView) hotCity.findViewById(R.id.gridview);
        GvAdapter gvAdapter_hot = new GvAdapter(2); //0定位城市，1最近访问城市，2热门城市
        gv_hotcity.setAdapter(gvAdapter_hot);

        mListview.addHeaderView(nowCity);
        mListview.addHeaderView(recentCity);
        mListview.addHeaderView(hotCity);
        mListview.setAdapter(mLvAdapter);

        mSerchLvAdapter = new SerchLvAdapter();
        lvSearch.setAdapter(mSerchLvAdapter);

        edtLocation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchList.clear();
                String text = s + "";
                if (text.isEmpty()) {
                    lvSearch.setVisibility(View.GONE);
                    locationLinear.setVisibility(View.VISIBLE);
                    image.setVisibility(View.VISIBLE);
                } else {
                    lvSearch.setVisibility(View.VISIBLE);
                    locationLinear.setVisibility(View.GONE);
                    image.setVisibility(View.GONE);
                    for (int i = 0; i < citiesList.size(); i++) {
                        City.AllcityBean allcityBean = citiesList.get(i);
                        if (allcityBean.getName().contains(s + "") || allcityBean.getPinyin().contains(s + "")) {
                            searchList.add(allcityBean.getName());
                        }
                    }
                    mSerchLvAdapter.notifyDataSetChanged();
                    showShortToast(s + "--" + searchList.size());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    class GvAdapter extends BaseAdapter {

        int type;

        public GvAdapter(int type) {
            this.type = type;
        }

        @Override
        public int getCount() {
            if (type == 0) {
                return 1;
            } else if (type == 1) {
                return 3;
            } else {
                return 6;
            }
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = mInflater.inflate(R.layout.item_gv_location_head, null);
            TextView name = (TextView) view.findViewById(R.id.text);
            if (type == 0) {
                name.setText(nowCity);
            }
            return view;
        }
    }

    class lvAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return citiesList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = mInflater.inflate(R.layout.item_lv_locationact, null);
            TextView t1 = (TextView) view.findViewById(R.id.text_letter);
            TextView t2 = (TextView) view.findViewById(R.id.text_city);
            RelativeLayout rela_letter = (RelativeLayout) view.findViewById(R.id.rela_letter);
            City.AllcityBean allcity = citiesList.get(position);

            String string = allcity.getPinyin();
            // 得到首字母
            String substring = string.substring(0, 1);
            if (position == 0) {
                t1.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);
                t1.setText(substring.toUpperCase());
                t2.setText(allcity.getName());
            } else {
                // 上一个字符串
                String string2 = citiesList.get(position - 1).getPinyin();
                // 上一个字符串的首字母
                String substring2 = string2.substring(0, 1);
                // 如果两个字母一样
                if (substring2.equals(substring)) {
                    rela_letter.setVisibility(View.GONE);
                    t2.setText(citiesList.get(position).getName());
                } else { // 如果首字母不一样
                    t1.setText(substring.toUpperCase());
                    t2.setText(citiesList.get(position).getName());
                }
            }
            return view;
        }
    }

    class SerchLvAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            if (searchList.size() == 0) {
                return 1;
            } else {
                return searchList.size();
            }
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = mInflater.inflate(R.layout.item_lv_search, null);
            TextView text = (TextView) view.findViewById(R.id.text_city);
            if (searchList.size() == 0) {
                text.setText("抱歉，暂时没有找到相关城市");
            } else {
                text.setText(searchList.get(position));
            }
            return view;
        }
    }

    /**
     * 从assert文件夹中读取省市区的json文件，然后转化为json对象
     * Created by zyz on 2016/5/24
     * QQ: 344100167
     * Github: https://github.com/yazhi1992
     */
    String mJsonObj;
    private void initJsonData() {
        try {
            StringBuffer sb = new StringBuffer();
            InputStream is = getAssets().open("citie2.json");
            int len = -1;
            byte[] buf = new byte[1024];
            while ((len = is.read(buf)) != -1) {
                sb.append(new String(buf, 0, len, "utf-8"));
            }
            is.close();
            mJsonObj = sb.toString();
            initData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initData() {
        City city = GsonUtils.parseJSON(mJsonObj, City.class);
        List<City.AllcityBean> allcity = city.getAllcity();
        citiesList.addAll(allcity);
        mLvAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocationClient.stopLocation();//停止定位
        mLocationClient.onDestroy();//销毁定位客户端。
    }
}
