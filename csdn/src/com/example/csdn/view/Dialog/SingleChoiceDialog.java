package com.example.csdn.view.Dialog;

import java.util.List;

import com.example.csdn.util.Utils;
import  com.example.csdn.R;



import android.content.Context;

public class SingleChoiceDialog extends AbstractChoickDialog{

	private SingleChoicAdapter<String> mSingleChoicAdapter;

	public SingleChoiceDialog(Context context, List<String> list) {
		super(context, list);
		
		initData();
	}

	protected void initData() {
		// TODO Auto-generated method stub
		mSingleChoicAdapter = new SingleChoicAdapter<String>(mContext, mList, R.drawable.selector_checkbox2);
		mListView.setAdapter(mSingleChoicAdapter);
		mListView.setOnItemClickListener(mSingleChoicAdapter);   
		Utils.setListViewHeightBasedOnChildren(mListView);
	}


	public int getSelectItem()
	{
		return mSingleChoicAdapter.getSelectItem();
	}


}
