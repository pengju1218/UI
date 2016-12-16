package com.example.csdn.frag;

import java.util.ArrayList;
import java.util.List;

import com.example.csdn.R;
import com.example.csdn.util.Utils;
import com.example.csdn.view.Text.AlignText;
import com.example.csdn.view.layout.weight.CardUIView;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CardFrag extends Fragment {


	private List<View> viewList = new ArrayList<View>();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		addViews();
		
	  CardUIView card=new CardUIView(getActivity());
	  card.setViewList(viewList);
		
		
		return card;
	}
	public void addViews() {
		View aView = LayoutInflater.from(getActivity()).inflate(R.layout.card_a, null);
		View bView = LayoutInflater.from(getActivity()).inflate(R.layout.card_b, null);
		View cView = LayoutInflater.from(getActivity()).inflate(R.layout.card_c, null);
		View dView = LayoutInflater.from(getActivity()).inflate(R.layout.card_d, null);
		viewList.add(aView);
		viewList.add(bView);
		viewList.add(cView);
		viewList.add(dView);
	

	}
}
