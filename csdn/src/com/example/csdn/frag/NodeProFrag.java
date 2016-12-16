package com.example.csdn.frag;

import com.example.csdn.R;
import com.example.csdn.bean.Type;
import com.example.csdn.view.Button.CircularProgressButton;
import com.example.csdn.view.Button.SlideButton;
import com.example.csdn.view.Button.SlipButton;
import com.example.csdn.view.Button.SlipButton.OnChangedListener;
import com.example.csdn.view.Button.interf.OnToggleStateChangeListener;
import com.example.csdn.view.ProgressBar.ArrowProgressBar;
import com.example.csdn.view.ProgressBar.NodeProgressBar;
import com.example.csdn.view.Text.ClockText;
import com.example.csdn.view.Text.TextViewMultilineEllipse;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

@SuppressLint("ValidFragment")
public class NodeProFrag extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.item_pro_frag, container,
				false);

		NodeProgressBar mArrowProgressBar = (NodeProgressBar) view
				.findViewById(R.id.ssl);
		mArrowProgressBar.setProgressAndIndex(2);

		return view;
	}

}
