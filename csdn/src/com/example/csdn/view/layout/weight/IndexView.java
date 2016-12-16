package com.example.csdn.view.layout.weight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.csdn.R;
import com.example.csdn.bean.IndexGroup;
import com.example.csdn.bean.ItemBean;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.LinearLayout;

public class IndexView extends LinearLayout {

	private int item_height = 50;

	private onItemClick itemClick;

	public int getItem_height() {
		return item_height;
	}

	public void setItem_height(int item_height) {
		this.item_height = item_height;
	}

	public IndexView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);

	}

	public IndexView(Context context) {
		super(context);
		init(context);
	}

	/*
	 * public void initg(){ g=new IndexGroup(); List<String> list1=new
	 * ArrayList<String>(); Map<String ,List<ItemBean>> maps=new HashMap<String,
	 * List<ItemBean>>();
	 * 
	 * String lv1="LTC"; String[] lv2={"MO","MCL","MP"};
	 * 
	 * String[][] items={{"预销售转销售周期","预销售四定现率"},{"客户化合同要素基线改进率"},{"要货预测准确率"}};
	 * 
	 * for(int i=0;i<lv2.length; i++){ list1.add(lv2[i]);
	 * 
	 * List<ItemBean> li=new ArrayList<ItemBean>();
	 * 
	 * for(int j=0;j<items[i].length;j++ ){ ItemBean b=new ItemBean();
	 * b.setName(items[i][j]); b.setImage_id(R.drawable.ic_launcher);
	 * b.setClick(false); b.setId("11"); li.add(b); } maps.put(lv2[i], li); }
	 * 
	 * g.setLv1(lv1); g.setLv2(list1); g.setMaps(maps);
	 * 
	 * }
	 */

	public onItemClick getItemClick() {
		return itemClick;
	}

	public void setItemClick(onItemClick itemClick) {
		this.itemClick = itemClick;
	}

	public void init(Context con) {

		this.setOrientation(VERTICAL);

	}

	public void setItem(Context con, IndexGroup g) {
		this.removeAllViews();
		int itmes_number = 0;
		WindowManager wm = (WindowManager) con
				.getSystemService(Context.WINDOW_SERVICE);
		int width = wm.getDefaultDisplay().getWidth();
		LinearLayout line0 = new LinearLayout(con);

		line0.setOrientation(HORIZONTAL);

		LinearLayout linear1 = getLinearLayoutView(width / 8, con);
		LinearLayout linear2 = getLinearLayoutView(width / 8, con);
		LinearLayout linear3 = getLinearLayoutView(width / 4 * 3 - 60, con);

		List<String> lv2 = g.getLv2();
		Map<String, List<ItemBean>> maps = g.getMaps();

		ItemView lv1_item = new ItemView(con);
		lv1_item.setText(g.getLv1());
		for (int i = 0; i < lv2.size(); i++) {

			String lv2_name = lv2.get(i);
			ItemView lv2_item = new ItemView(con);
			lv2_item.setText(lv2_name);
			LinearLayout.LayoutParams lv2_params = new LayoutParams(
					LayoutParams.MATCH_PARENT, getItem_height()
							* (maps.get(lv2_name).size()));
			lv2_item.setLayoutParams(lv2_params);
			linear2.addView(lv2_item);
			itmes_number += maps.get(lv2_name).size();

			for (int j = 0; j < maps.get(lv2_name).size(); j++) {

				ItemBean bean = maps.get(lv2_name).get(j);

				ItemView item_b = new ItemView(con);

				item_b.setImageResource(bean.getImage_id());
				item_b.setText(bean.getName());
				item_b.setItem_id(bean.getId());
				item_b.setKey(lv2_name);
				item_b.setImageVisiable(View.VISIBLE);
				LinearLayout.LayoutParams item_params = new LayoutParams(
						LayoutParams.MATCH_PARENT, getItem_height());
				item_b.setLayoutParams(item_params);
				item_b.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						itemClick.setOnItemClick(arg0);
					}
				});

				linear3.addView(item_b);

			}
		}
		LinearLayout.LayoutParams lv1_params = new LayoutParams(
				LayoutParams.MATCH_PARENT, getItem_height() * (itmes_number));

		lv1_item.setLayoutParams(lv1_params);
		linear1.addView(lv1_item);

		line0.setLayoutParams(lv1_params);
		line0.addView(getLineView(getItem_height() * itmes_number, con));
		line0.addView(linear1);
		line0.addView(getLineView(getItem_height() * itmes_number, con));
		line0.addView(linear2);
		line0.addView(getLineView(getItem_height() * itmes_number, con));
		line0.addView(linear3);
		line0.addView(getLineView(getItem_height() * itmes_number, con));

		this.addView(line0);
		this.addView(getLastLine(con));

	}

	public View getLineView(int height, Context con) {

		View v = new View(con);
		LinearLayout.LayoutParams params = new LayoutParams(1, height);
		v.setLayoutParams(params);
		v.setBackgroundColor(con.getResources().getColor(R.color.lightgray));
		return v;
	}

	public View getLastLine(Context con) {

		View v = new View(con);
		LinearLayout.LayoutParams params = new LayoutParams(
				LayoutParams.MATCH_PARENT, 1);
		v.setLayoutParams(params);
		v.setBackgroundColor(con.getResources().getColor(R.color.lightgray));
		return v;
	}

	public LinearLayout getLinearLayoutView(int width, Context con) {

		LinearLayout v = new LinearLayout(con);
		v.setOrientation(VERTICAL);
		LinearLayout.LayoutParams params = new LayoutParams(width,
				LayoutParams.MATCH_PARENT);
		v.setLayoutParams(params);

		return v;
	}

	public interface onItemClick {
		public void setOnItemClick(View v);
	}

}
