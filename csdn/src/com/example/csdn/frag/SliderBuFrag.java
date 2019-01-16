package com.example.csdn.frag;

import com.example.csdn.R;
import com.example.csdn.bean.Type;
import com.example.csdn.view.Button.SlideButton;
import com.example.csdn.view.Button.SwitchButton;
import com.example.csdn.view.Button.SwitchButton.OnChangeListener;
import com.example.csdn.view.Button.interf.OnToggleStateChangeListener;
import com.example.csdn.view.Text.ClockText;
import com.example.csdn.view.Text.TextViewMultilineEllipse;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

@SuppressLint("ValidFragment")
public class SliderBuFrag extends BaseFrag implements  OnToggleStateChangeListener {

	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.item_slide_button_frag, container,
				false);

		SlideButton slideButton = (SlideButton) view.findViewById(R.id.slidebutton);
		slideButton.setToggleState(true);
		slideButton.setOnToggleStateChangeListener(this);
		
		
		SwitchButton sb = (SwitchButton)  view.findViewById(R.id.wiperSwitch1);
		sb.setOnChangeListener(new OnChangeListener() {
			
			@Override
			public void onChange(SwitchButton sb, boolean state) {
				// TODO Auto-generated method stub
				//Log.d("switchButton", state ? "开":"关");
				Toast.makeText(getActivity(), state ? "开":"关", Toast.LENGTH_SHORT).show();
			}
		});
		return view;
	}

	@Override
	public void onToggleStateChange(boolean b) {
		// TODO Auto-generated method stub
		if (b) {
			Toast.makeText(getActivity(), "开关打开", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(getActivity(), "开关关闭", Toast.LENGTH_SHORT).show();
		}
	}

}
