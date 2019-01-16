package com.example.csdn.frag;

import com.example.csdn.R;
import com.example.csdn.bean.Type;
import com.example.csdn.view.Button.CircularProgressButton;

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
public class CircleProBuFrag extends BaseFrag  {

	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.item_circlepro_button_frag, container,
				false);

		CircularProgressButton sb = (CircularProgressButton) view.findViewById(R.id.btnWithIcons1);
		sb.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				((CircularProgressButton)view).setProgress(90);
			}
		});

		return view;
	}


}
