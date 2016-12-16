package com.example.csdn.view.ProgressBar;


import com.example.csdn.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class LoadProgressBar extends LinearLayout{

	public LoadProgressBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		   init();
		   LayoutInflater.from(context).inflate(R.layout.loadprogress, this, true);
	
	}

	ProgressBar bar=null;
	public LoadProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		   init();
		   LayoutInflater.from(context).inflate(R.layout.loadprogress, this, true);  
	        
	}
	 public void init(){
	    	this.setOrientation(LinearLayout.HORIZONTAL);  
	    	@SuppressWarnings("deprecation")
			LayoutParams params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
	    	this.setLayoutParams(params);
	    }
	
}