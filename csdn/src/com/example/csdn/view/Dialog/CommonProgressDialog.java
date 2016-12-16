package com.example.csdn.view.Dialog;
import java.text.NumberFormat;

import  com.example.csdn.R;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.widget.ProgressBar;
import android.widget.TextView;


public class CommonProgressDialog extends AlertDialog {


	private ProgressBar mProgress;
	private TextView mProgressNumber;
	private TextView mProgressPercent;
	private TextView mProgressMessage;
	private int mMax;
	private String mProgressNumberFormat;
	private NumberFormat mProgressPercentFormat;
	public CommonProgressDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		initFormats();
	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog);
		mProgress=(ProgressBar) findViewById(R.id.progress);
		mProgressNumber=(TextView) findViewById(R.id.progress_number);
		mProgressPercent=(TextView) findViewById(R.id.progress_percent);
		mProgressMessage=(TextView) findViewById(R.id.progress_message);
	}
	private void initFormats() {
		mProgressNumberFormat = "%1.2fM/%2.2fM";
		mProgressPercentFormat = NumberFormat.getPercentInstance();
		mProgressPercentFormat.setMaximumFractionDigits(0);
	}
	
	public void setProgressStyle(int style) {
		//mProgressStyle = style;
	}
	public int getMax() {
		if (mProgress != null) {
			return mProgress.getMax();
		}
		return mMax;
	}
	public void setMax(int max) {
		if (mProgress != null) {
			mProgress.setMax(max);
			
		} else {
			mMax = max;
		}
	}
	
	public void setProgress(int value) {
			mProgress.setProgress(value);
	}

	public void setTextPercent(float percent){
		if (mProgressPercentFormat != null) {
			SpannableString tmp = new SpannableString(mProgressPercentFormat.format(percent));
			tmp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD),0, tmp.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			mProgressPercent.setText(tmp);
		} else {
			mProgressPercent.setText("");
		}
	}
	
	
	public int getProgress(){
		return mProgress.getProgress();
	}
	
	
	public void setTextNumber(int progress,int max){
		
		double dProgress = (double)progress/(double)(1024 * 1024);
		double dMax = (double)max/(double)(1024 * 1024);
		if (mProgressNumberFormat != null) {
			String format = mProgressNumberFormat;
			mProgressNumber.setText(String.format(format, dProgress, dMax));
		} else {
			mProgressNumber.setText("");
		}
	}
	
	public void setTitleText(String text){
		if(mProgressMessage!=null)
			mProgressMessage.setText(text);
	}
}