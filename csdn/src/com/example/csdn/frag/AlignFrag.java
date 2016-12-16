package com.example.csdn.frag;

import com.example.csdn.R;
import com.example.csdn.util.Utils;
import com.example.csdn.view.Text.AlignText;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AlignFrag extends Fragment {

	private AlignText aTextView;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		aTextView.setText(Utils.getAssetsString(getActivity(), "1.txt"));
		//aTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// return inflater.inflate(R.layout.item_align_frag, container, false);
		View view = inflater
				.inflate(R.layout.item_align_frag, container, false);
		aTextView = (AlignText) view.findViewById(R.id.view);
		return view;
	}
}
