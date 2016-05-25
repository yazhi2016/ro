package com.xmzlb.iron.weight;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xmzlb.iron.R;


public class CustomDialog extends DialogFragment {
	private onConfirmListener listener;

	interface onConfirmListener{
		void onConfirm(String name, String pwd);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		getDialog().requestWindowFeature(STYLE_NO_TITLE);
		View view=inflater.inflate(R.layout.layout_mydialog, null);

		return view;
	}
	
	public void setOnConfirmListener(onConfirmListener l){
		listener=l;
	}

}
