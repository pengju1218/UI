package com.example.csdn;

import android.app.FragmentBreadCrumbs;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.csdn.bean.BaseActivity;
import com.example.csdn.inter.imp.FragFactory;

public class FragActivity extends BaseActivity implements OnClickListener {
	private RelativeLayout back;
	private TextView title;
	private String type, name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		back = (RelativeLayout) findViewById(R.id.r_back);
		title = (TextView) findViewById(R.id.title);
		back.setOnClickListener(this);
		Intent intent = getIntent();
		type = intent.getExtras().getString("frag_type");
		name = intent.getExtras().getString("frag_name");
		title.setText(name);
		showFrag(type);
	}

	public void showFrag(String type) {
		FragFactory factory=new FragFactory();
		Fragment frag=factory.createFrag(type);
		FragmentTransaction ft = FragActivity.this.getSupportFragmentManager()
				.beginTransaction();
		ft.replace(R.id.article_fragment, frag);
		ft.commit();

	}

	@Override
	public void onClick(View arg0) {
		if (R.id.r_back == arg0.getId()) {
			finish();
		}

	}
}
