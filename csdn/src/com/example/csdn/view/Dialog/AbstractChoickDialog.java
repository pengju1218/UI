package com.example.csdn.view.Dialog;

import java.util.List;

import  com.example.csdn.R;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public abstract class AbstractChoickDialog extends Dialog implements OnClickListener{

	protected Context mContext;
	protected View mParentView;
	protected View mRootView;

	
	protected TextView mTVTitle;
	protected Button mButtonOK;
	protected Button mButtonCancel;
	protected ListView mListView;
	
	protected List<String> mList;
	protected OnClickListener mOkClickListener;
	
	public AbstractChoickDialog(Context context, List<String> list) {
		super(context);
		// TODO Auto-generated constructor stub
		
		mContext = context;
		mList = list;
	
		
		initView(mContext);
		
		
	}
	
	
	protected void initView(Context context)
	{
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.pup_window);
		mRootView = findViewById(R.id.rootView);
		mTVTitle = (TextView) findViewById(R.id.tvTitle);
		mButtonOK = (Button) findViewById(R.id.btnOK);
		mButtonOK.setOnClickListener(this);
		mButtonCancel = (Button) findViewById(R.id.btnCancel);
		mButtonCancel.setOnClickListener(this);
		mListView = (ListView)findViewById(R.id.listView);   	
	}
	
	public void setTitle(String title)
	{
		mTVTitle.setText(title);
	}
	
	public void setOnOKButtonListener(OnClickListener onClickListener) {
		mOkClickListener = onClickListener;
	}

	
	
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.btnOK:
			onButtonOK();
			break;
		case R.id.btnCancel:
			onButtonCancel();
			break;
		}
	}
	
	protected void onButtonOK()
	{
		dismiss();
		
		if (mOkClickListener != null)
		{
			mOkClickListener.onClick(this, 0);
		}
	}
	
	protected void onButtonCancel()
	{
		dismiss();

	}
}
