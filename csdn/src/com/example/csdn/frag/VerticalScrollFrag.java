package com.example.csdn.frag;

import java.util.ArrayList;
import java.util.List;
import com.example.csdn.R;
import com.example.csdn.util.Utils;
import com.example.csdn.view.Text.AlignText;
import com.example.csdn.view.Text.MarqueeText;
import com.example.csdn.view.Text.VerticalScrollTextView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class VerticalScrollFrag extends BaseFrag {

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// return inflater.inflate(R.layout.item_align_frag, container, false);
		View view = inflater.inflate(R.layout.item_vertical_frag, container,
				false);
		VerticalScrollTextView	intro = (VerticalScrollTextView) view.findViewById(R.id.intro);
		List<String> tBeans = new ArrayList<String>();
		tBeans.add("安卓(android)中文第一门户-安卓游戏-安卓软件-安卓系统");
		tBeans.add("巴士商店- 电玩巴士安卓市场- Android安卓中文网");
		tBeans.add("Android安卓中文论坛- 口袋巴士_手机游戏玩家第一论坛");
		//intro.setStopTime(5000);  //设置停留时间
		if (tBeans!=null&&tBeans.size()>0) {
		
			StringBuilder sBuilder = new StringBuilder();
			for (String threadlistBean : tBeans) {
				String content = threadlistBean;
				//content = content.length()>=15?content.substring(0, 14)+"..":content;
				sBuilder.append(content).append("k#");
			}
			sBuilder.deleteCharAt(sBuilder.lastIndexOf("#"));
			sBuilder.deleteCharAt(sBuilder.lastIndexOf("k"));
			intro.setScrollText(sBuilder.toString().trim());
			
		}
		return view;
	}
}
