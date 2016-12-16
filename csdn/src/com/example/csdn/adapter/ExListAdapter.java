package com.example.csdn.adapter;

import java.util.List;

import com.example.csdn.FragActivity;
import com.example.csdn.R;
import com.example.csdn.bean.Child;
import com.example.csdn.bean.Group;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ExListAdapter extends BaseExpandableListAdapter {

	private Context context;
	private List<Group> group;
	private LayoutInflater inflater = null;

	public ExListAdapter(Context context, List<Group> group) {
		this.context = context;
		this.group = group;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public Object getChild(int arg0, int arg1) {
		
		return group.get(arg0).getChildren().get(arg1);
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		
		return arg1;
	}

	@Override
	public View getChildView(int arg0, int arg1, boolean arg2, View arg3,
			ViewGroup arg4) {
		ViewHoler viewHoler = null;
		if (arg3 == null) {
			viewHoler = new ViewHoler();
			arg3 = inflater.inflate(R.layout.main_child_item, null);
			viewHoler.childName = (TextView) arg3.findViewById(R.id.child_name);
			arg3.setTag(viewHoler);
		} else {
			viewHoler = (ViewHoler) arg3.getTag();
		}
		final Child child=group.get(arg0).getChildren().get(arg1);
		String childSName = group.get(arg0).getChildren().get(arg1).getName();
		viewHoler.childName.setText(childSName);
		arg3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(context,FragActivity.class);
				intent.putExtra("frag_type", child.getType());
				intent.putExtra("frag_name", child.getName());
				context.startActivity(intent);
			}
		});
		return arg3;
	}

	@Override
	public int getChildrenCount(int arg0) {
		
		return group.get(arg0).getChildren().size();
	}

	@Override
	public Object getGroup(int arg0) {
		
		return group.get(arg0);
	}

	@Override
	public int getGroupCount() {
		
		return group.size();
	}

	@Override
	public long getGroupId(int arg0) {
		
		return arg0;
	}

	@Override
	public View getGroupView(int arg0, boolean arg1, View arg2, ViewGroup arg3) {
		ViewHoler viewHoler = null;
		if (arg2 == null) {
			viewHoler = new ViewHoler();
			arg2 = inflater.inflate(R.layout.main_group_item, null);
			viewHoler.groupName = (TextView) arg2.findViewById(R.id.group_name);
			viewHoler.img = (ImageView) arg2.findViewById(R.id.group_img);
			arg2.setTag(viewHoler);
		} else {
			viewHoler = (ViewHoler) arg2.getTag();
		}
		String groupSName = group.get(arg0).getName();
		viewHoler.groupName.setText(groupSName);

		if(arg1){
			viewHoler.img.setImageResource(R.drawable.indicator_up);
		}else{
			viewHoler.img.setImageResource(R.drawable.indicator_down);
		}
		
		return arg2;
	}

	@Override
	public boolean hasStableIds() {

		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {

		return false;
	}

	class ViewHoler {
		private TextView groupName;
		private TextView childName;
		private ImageView img;
	}

}
