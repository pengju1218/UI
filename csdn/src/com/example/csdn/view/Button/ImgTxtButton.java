package com.example.csdn.view.Button;

import  com.example.csdn.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ImgTxtButton extends RelativeLayout {
	
	private ImageView imgView;  
	private TextView  textView;

	public ImgTxtButton(Context context) {
		super(context,null);
	}
	
	public ImgTxtButton(Context context,AttributeSet attributeSet) {
		super(context, attributeSet);
		
		LayoutInflater.from(context).inflate(R.layout.img_text_bt, this,true);
		
		this.imgView = (ImageView)findViewById(R.id.imgview);
		this.textView = (TextView)findViewById(R.id.textview);
		
		this.setClickable(true);
		this.setFocusable(true);
	}
	
	public void setImgResource(int resourceID) {
		this.imgView.setImageResource(resourceID);
	}
	
	public void setText(String text) {
		this.textView.setText(text);
	}
	
	public void setTextColor(int color) {
		this.textView.setTextColor(color);
	}
	
	public void setTextSize(float size) {
		this.textView.setTextSize(size);
	}
	
}
