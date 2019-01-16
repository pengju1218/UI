package com.example.csdn.frag;

import com.example.csdn.R;
import com.example.csdn.bean.Type;
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

@SuppressLint("ValidFragment")
public class NewFrag extends BaseFrag {

	private String type;

	@SuppressLint("ValidFragment")
	public NewFrag(String type) {
		this.type = type;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return getViewFormType(type);
	}

	public View getViewFormType(String Types) {
		View view = new View(getActivity());
		if (Type.CLOCK_TEXT.equals(Types)) {
			ClockText clock = new ClockText(getActivity());
			clock.setFormat("yyyy-MM-dd hh:mm:ss");
			view = clock;
		} else if (Type.MULTI_ELLIPSE_TEXT.equals(Types)) {
			final String text = "明月几时有？把酒问青天。不知天上宫阙，今夕是何年。\n"
					+ "我欲乘风归去，又恐琼楼玉宇，高处不胜寒。\n" + "起舞弄清影，何似在人间。\n"
					+ "转朱阁，低绮户，照无眠。不应有恨，何事长向别时圆？\n" + "人有悲欢离合，月有阴晴圆缺，此事古难全。\n"
					+ "但愿人长久，千里共婵娟。";
			// 共同的宽高
			LayoutParams lp = new LayoutParams(LayoutParams.FILL_PARENT, 300);
			TextViewMultilineEllipse tvMultilineEllipse = new TextViewMultilineEllipse(
					getActivity());
			tvMultilineEllipse.setLayoutParams(lp);// 限制TextView的宽高
			tvMultilineEllipse.setEllipsis("...");// ...替换剩余字符串
			tvMultilineEllipse.setMaxLines(5);
			tvMultilineEllipse.setTextSize(20);// 设置文字大小
			tvMultilineEllipse.setTextColor(Color.GREEN);
			tvMultilineEllipse.setText(text);// 设置文本
			view = tvMultilineEllipse;
		}

		return view;
	}
}
