package com.example.csdn.view.Button;

import  com.example.csdn.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class ColorButton extends Button  
{
	
	private Context context;
	public ColorButton(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context=context;
		init();
	}

	public ColorButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	    this.context=context;
		init();
	}

	public void init(){
		
		this.setBackgroundResource(R.drawable.btn_green);
		this.setTextAppearance(context, R.style.ButtonText);
	}


}
