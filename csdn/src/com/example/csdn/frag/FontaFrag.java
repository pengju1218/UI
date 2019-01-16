package com.example.csdn.frag;

import com.example.csdn.R;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
@SuppressLint("ValidFragment")
public class FontaFrag extends BaseFrag {

	int layoutId;
	@SuppressLint("ValidFragment")
       public FontaFrag(int layoutId){
		   this.layoutId=layoutId;
	   }



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		 return inflater.inflate(layoutId,container, false);
				 
				
	}
}
