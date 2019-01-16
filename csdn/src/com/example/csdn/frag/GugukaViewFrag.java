package com.example.csdn.frag;


import com.example.csdn.R;
import com.example.csdn.bean.Type;
import com.example.csdn.view.Button.SlideButton;
import com.example.csdn.view.Button.SlipButton;
import com.example.csdn.view.Button.SlipButton.OnChangedListener;
import com.example.csdn.view.Button.interf.OnToggleStateChangeListener;
import com.example.csdn.view.ImageView.GifView;
import com.example.csdn.view.Text.ClockText;
import com.example.csdn.view.Text.TextViewMultilineEllipse;
import com.example.csdn.view.View.XCGuaguakaView;
import com.example.csdn.view.View.XCGuaguakaView.OnCompleteListener;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

public class GugukaViewFrag extends BaseFrag{


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.item_guguka_view, container,
				false);
		XCGuaguakaView xcGuaguakaView = (XCGuaguakaView)view.findViewById(R.id.ggk);
	        xcGuaguakaView.setOnCompleteListener(new OnCompleteListener() {
	            
	            @Override
	            public void complete() {
	                // TODO Auto-generated method stub
	                Toast.makeText(getActivity(), "您已经刮的差不多啦", Toast.LENGTH_SHORT).show();
	            }
	        });
		
		return view;
	}

	
}
