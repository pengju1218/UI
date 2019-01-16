package com.example.csdn.frag;

import com.example.csdn.R;
import com.example.csdn.util.Utils;
import com.example.csdn.view.Text.AlignText;
import com.example.csdn.view.Text.MarqueeText;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MarqueeFrag extends BaseFrag {

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// return inflater.inflate(R.layout.item_align_frag, container, false);
		View view = inflater.inflate(R.layout.item_marquee_frag, container,
				false);
		MarqueeText mMarqueeText = (MarqueeText) view.findViewById(R.id.marqueeText);
		mMarqueeText.startScroll();

		return view;
	}
}
