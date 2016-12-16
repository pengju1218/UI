package com.example.csdn.adapter;

import java.util.List;

import com.example.csdn.R;
import com.example.csdn.bean.IndexGroup;
import com.example.csdn.view.layout.weight.IndexView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class GAdapter extends BaseAdapter {

	private List<IndexGroup> list;

	private Context con;

	public GAdapter(Context con, List<IndexGroup> list) {
		this.con = con;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		Hodler h = null;
		if (arg1 == null) {
			arg1 = LayoutInflater.from(con).inflate(R.layout.index, null);

			h = new Hodler();
			h.index = (IndexView) arg1.findViewById(R.id.aa);
			arg1.setTag(h);
		}

		h = (Hodler) arg1.getTag();
		h.index.setItem(con, list.get(arg0));

		return arg1;
	}

	class Hodler {
		IndexView index;
	}

}