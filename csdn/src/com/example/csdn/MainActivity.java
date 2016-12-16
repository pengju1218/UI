package com.example.csdn;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.csdn.R;
import com.example.csdn.adapter.ExListAdapter;
import com.example.csdn.bean.BaseActivity;
import com.example.csdn.bean.Group;
import com.example.csdn.util.DataGenerator;

public class MainActivity extends BaseActivity implements OnClickListener {
	private ExpandableListView expandableListView = null;
	private ExListAdapter adapter = null;
	private RelativeLayout back;
	private TextView title;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_main);
		expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
		back=(RelativeLayout)findViewById(R.id.r_back);
		title=(TextView)findViewById(R.id.title);
		title.setText(R.string.title_index);
		back.setOnClickListener(this);
		List<Group> groups = new DataGenerator().getGroups();
		adapter = new ExListAdapter(this, groups);
		expandableListView.setGroupIndicator(null);
		expandableListView.setAdapter(adapter);
	}

	@Override
	public void onClick(View arg0) {
		if(R.id.r_back==arg0.getId()){
			finish();
		}
		
	}

}
