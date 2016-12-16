package com.example.csdn.frag;

import com.example.csdn.R;
import com.example.csdn.util.Utils;
import com.example.csdn.view.Text.AlignText;
import android.view.animation.Transformation;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

public class MoreTxtFrag extends Fragment {

	TextView descriptionView;
	View expandView;
	int maxDescripLine = 3;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// return inflater.inflate(R.layout.item_align_frag, container, false);
		View view = inflater
				.inflate(R.layout.item_more_txt_frag, container, false);
		descriptionView = (TextView)view.findViewById(R.id.description_view);
		expandView = view.findViewById(R.id.expand_view);
		descriptionView.setText(getText(R.string.content));
		descriptionView.setHeight(descriptionView.getLineHeight() * maxDescripLine);
		descriptionView.post(new Runnable() {
			
			@Override
			public void run() {
				expandView.setVisibility(descriptionView.getLineCount() > maxDescripLine ? View.VISIBLE : View.GONE);
				
			}
		});
		
		view.findViewById(R.id.description_layout).setOnClickListener(new View.OnClickListener() {
			boolean isExpand;

			@Override
			public void onClick(View v) {
				isExpand = !isExpand;
				descriptionView.clearAnimation();
				final int deltaValue;
				final int startValue = descriptionView.getHeight();
				int durationMillis = 350;
				if (isExpand) {
					deltaValue = descriptionView.getLineHeight() * descriptionView.getLineCount() - startValue;
					RotateAnimation animation = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
					animation.setDuration(durationMillis);
					animation.setFillAfter(true);
					expandView.startAnimation(animation);
				} else {
					deltaValue = descriptionView.getLineHeight() * maxDescripLine - startValue;
					RotateAnimation animation = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
					animation.setDuration(durationMillis);
					animation.setFillAfter(true);
					expandView.startAnimation(animation);
				}
				Animation animation = new Animation() {
					protected void applyTransformation(float interpolatedTime, Transformation t) {
						descriptionView.setHeight((int) (startValue + deltaValue * interpolatedTime));
					}

				};
				animation.setDuration(durationMillis);
				descriptionView.startAnimation(animation);
			}
		});
		return view;
	}
}
