package com.example.csdn.frag;

import com.example.csdn.R;
import com.example.csdn.bean.Type;
import com.example.csdn.view.Button.SlideButton;
import com.example.csdn.view.Button.SlipButton;
import com.example.csdn.view.Button.SlipButton.OnChangedListener;
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
public class SlipBuFrag extends Fragment implements  OnToggleStateChangeListener {

	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.item_slip_button_frag, container,
				false);

		SlipButton sb = (SlipButton) view.findViewById(R.id.slipbutton);
		sb.setCheck(true);
		sb.SetOnChangedListener(new OnChangedListener() {

			public void OnChanged(boolean CheckState) {
				Toast.makeText(getActivity(), String.valueOf(CheckState)+"", Toast.LENGTH_LONG).show();
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
