package com.example.csdn.frag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.csdn.R;
import com.example.csdn.bean.Type;
import com.example.csdn.util.Utils;
import com.example.csdn.view.Button.SlideButton;
import com.example.csdn.view.Button.SwitchButton;
import com.example.csdn.view.Button.SwitchButton.OnChangeListener;
import com.example.csdn.view.Button.interf.OnToggleStateChangeListener;
import com.example.csdn.view.ListView.CornerListView;
import com.example.csdn.view.Text.ClockText;
import com.example.csdn.view.Text.TextViewMultilineEllipse;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SimpleAdapter;
import android.widget.Toast;

@SuppressLint("ValidFragment")
public class CornorLisFrag extends Fragment{

	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.item_cornor_listview_frag, container,
				false);
		CornerListView listview=(CornerListView)view.findViewById(R.id.cornerlist);
		listview.setAdapter(getSimpleAdapter_3());
		Utils.setListViewHeightBasedOnChildren(listview);
		return view;
	}

	private SimpleAdapter getSimpleAdapter_3() {
		ArrayList	listData3 = new ArrayList<Map<String, String>>();

		Map<String, String> map = new HashMap<String, String>();
		map.put("text", "检查新版本");
		listData3.add(map);

		map = new HashMap<String, String>();
		map.put("text", "发送建议");
		listData3.add(map);

		map = new HashMap<String, String>();
		map.put("text", "帮助");
		listData3.add(map);

		map = new HashMap<String, String>();
		map.put("text", "关于");
		listData3.add(map);

		return new SimpleAdapter(getActivity(), listData3,
				R.layout.item_cor, new String[] { "text" },
				new int[] { R.id.tv_list_item });

	}

}
