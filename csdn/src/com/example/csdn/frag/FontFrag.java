package com.example.csdn.frag;

import com.example.csdn.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FontFrag extends Fragment {
	
	private int layoutId;
	
	public FontFrag(int layoutId){
		this.layoutId=layoutId;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		 return inflater.inflate(layoutId,container, false);
				 
				
	}
}
