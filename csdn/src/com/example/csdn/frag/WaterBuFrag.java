package com.example.csdn.frag;

import com.example.csdn.R;
import com.example.csdn.bean.Type;
import com.example.csdn.view.Button.SlideButton;
import com.example.csdn.view.Button.WaterButton;
import com.example.csdn.view.Button.interf.OnToggleStateChangeListener;
import com.example.csdn.view.Button.interf.WhenClickCallback;
import com.example.csdn.view.Text.ClockText;
import com.example.csdn.view.Text.TextViewMultilineEllipse;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

@SuppressLint("ValidFragment")
public class WaterBuFrag extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.item_water_button_frag,
				container, false);

		OnClickListener l = new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(v.getContext(), "这个按钮" + v.getClass(),
						Toast.LENGTH_SHORT).show();
			}
		};

		WhenClickCallback cc = new WhenClickCallback() {
			private int performClicking;

			@Override
			public boolean performClick(int id) {
				if (performClicking == 0) {
					performClicking = id;
					return true;
				}
				return false;
			}

			@Override
			public int getState() {
				return performClicking;
			}

			@Override
			public void doneClick() {
				performClicking = 0;
			}
		};

		WaterButton button = (WaterButton) view.findViewById(R.id.button);
		button.setOnClickListener(l);

		button.registerCallback(cc);

		button.setWaterColor(Color.RED);
		return view;
	}

}
