package com.example.csdn.frag;

import com.example.csdn.R;
import com.example.csdn.util.Utils;
import com.example.csdn.view.Text.AlignText;

import com.example.csdn.view.View.SlidingTab;
import com.example.csdn.view.View.StepView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SlidingFrag extends Fragment {

	public String[] s = { "资金", "商品", "类型", "币种", "资金", "商品", "资金", "商品", "类型",
			"币种", "资金", "商品", "资金", "商品", "类型", "币种", "资金", "商品" };
	private SlidingTab slidingTab;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// return inflater.inflate(R.layout.item_align_frag, container, false);
		View view = inflater.inflate(R.layout.item_slid, container, false);
		slidingTab = (SlidingTab) view.findViewById(R.id.slidingtab);
		slidingTab.setTitles(s);
		slidingTab.requestDisallowInterceptTouchEvent(true);
		return view;
	}
}
