package com.xmzlb.iron.base;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseActivity extends FragmentActivity implements
		OnClickListener {
	protected BaseApplication mApplication;
	/**
	 * 屏幕的宽度、高度、密度
	 */
	protected int mScreenWidth;
	protected int mScreenHeight;
	protected float mDensity;

	protected List<AsyncTask<Void, Void, Object>> mAsyncTasks = new ArrayList<AsyncTask<Void, Void, Object>>();

	@SuppressWarnings("static-access")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
//		mApplication = (BaseApplication) getApplication();
//		mLoadingDialog = new FlippingLoadingDialog(this, "请求提交中");
		DisplayMetrics metric = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		mScreenWidth = metric.widthPixels;
		mScreenHeight = metric.heightPixels;
		mDensity = metric.density;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	/** 初始化事件 **/
	protected abstract void initEvents();

	/** 初始化数据 **/
	protected abstract void init();

//	protected void showLoadingDialog(String text) {
//		if (text != null) {
//			mLoadingDialog.setText(text);
//		}
//		mLoadingDialog.show();
//	}
//
//	protected void dismissLoadingDialog() {
//		if (mLoadingDialog.isShowing()) {
//			mLoadingDialog.dismiss();
//		}
//	}

	/** 短暂显示Toast提示(来自String) **/
	protected void showShortToast(String text) {
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}

	/** 长时间显示Toast提示(来自String) **/
	protected void showLongToast(String text) {
		Toast.makeText(this, text, Toast.LENGTH_LONG).show();
	}

	protected void showLog(String tag, String msg) {
		Log.i(tag, msg);
	}

	/** 通过Class跳转界面 **/
	protected void startActivity(Class<?> cls) {
		Intent intent = new Intent();
		intent.setClass(this, cls);
		startActivity(intent);
	}

}
