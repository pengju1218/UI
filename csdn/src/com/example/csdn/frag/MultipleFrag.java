package com.example.csdn.frag;

import java.util.ArrayList;
import java.util.List;

import com.example.csdn.R;
import com.example.csdn.util.Utils;
import com.example.csdn.view.Text.AlignText;
import com.example.csdn.view.Text.MarqueeText;
import com.example.csdn.view.Text.MultipleTextView;
import com.example.csdn.view.Text.MultipleTextView.OnMultipleTVItemClickListener;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MultipleFrag extends Fragment  implements OnMultipleTVItemClickListener {

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// return inflater.inflate(R.layout.item_align_frag, container, false);
		View view = inflater.inflate(R.layout.item_multiple_frag, container,
				false);
		
		
		List<String> dataList = new ArrayList<String>();
		dataList.add("Mason Liu");
		dataList.add("Mason Liu");
		
		dataList.add("天盟天盟天盟天盟");
		dataList.add("Mason Mason Mason");

		dataList.add("Mason Liu");
		dataList.add("天盟");
		dataList.add("天盟天盟天盟");
		dataList.add("Mason Mason");

		dataList.add("Mason");
		dataList.add("天");
		dataList.add("天");
		dataList.add("Ma");
		MultipleTextView rl=(MultipleTextView)view.findViewById(R.id.main_rl);
		rl.setOnMultipleTVItemClickListener(this);
		rl.setTextViews(dataList);
		
		
	
		return view;
	}

	@Override
	public void onMultipleTVItemClick(View view, int position) {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), "位置："+position, Toast.LENGTH_SHORT).show();
	}
}
