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

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

public class GifFrag extends Fragment{


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.item_gif_imagview_frag, container,
				false);
		GifView	gifView=(GifView)view.findViewById(R.id.gifView);

		gifView.setGifImage(R.drawable.myimg);

		gifView.setShowDimension(100, 100);
		
		return view;
	}

	
}
