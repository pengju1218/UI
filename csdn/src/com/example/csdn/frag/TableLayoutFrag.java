package com.example.csdn.frag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.csdn.R;
import com.example.csdn.adapter.GAdapter;
import com.example.csdn.bean.IndexGroup;
import com.example.csdn.bean.ItemBean;
import com.example.csdn.util.Utils;
import com.example.csdn.view.Text.AlignText;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class TableLayoutFrag extends BaseFrag {
	private String lv1 = "LTC";
	private String[] lv2 = { "MO", "MCL", "MP" };

	private String[][] items = { { "预销售转销售周期", "预销售四定现率" },
			{ "客户化合同要素基线改进率" }, { "要货预测准确率" } };

	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// return inflater.inflate(R.layout.item_align_frag, container, false);
		View view = inflater.inflate(R.layout.item_threetable_layout_frag,
				container, false);
		List<IndexGroup> l = new ArrayList<IndexGroup>();

		List<String> list1 = new ArrayList<String>();
		Map<String, List<ItemBean>> maps = new HashMap<String, List<ItemBean>>();

		IndexGroup g = new IndexGroup();

		for (int i = 0; i < lv2.length; i++) {
			list1.add(lv2[i]);

			List<ItemBean> li = new ArrayList<ItemBean>();

			for (int j = 0; j < items[i].length; j++) {
				ItemBean b = new ItemBean();
				b.setName(items[i][j]);
				b.setImage_id(R.drawable.ic_launcher);
				b.setClick(false);
				b.setId("11");
				li.add(b);
			}
			maps.put(lv2[i], li);
		}

		g.setLv1(lv1);
		g.setLv2(list1);
		g.setMaps(maps);

		/*
		 * IndexView v=(IndexView)findViewById(R.id.aa);
		 * 
		 * v.setItem(this, g);
		 * 
		 * v.setItemClick(new onItemClick() {
		 * 
		 * @Override public void setOnItemClick(View v) { // TODO Auto-generated
		 * method stub ItemView v1=(ItemView)v;
		 * Toast.makeText(MainActivity.this,
		 * v1.getText()+"--"+v1.getItem_id()+"--"+v1.getKey(), 1).show(); } });
		 */
		l.add(g);

		GAdapter adapter = new GAdapter(getActivity(), l);

		ListView lv = (ListView) view.findViewById(R.id.listView1);
		lv.setAdapter(adapter);

		return view;
	}

}
