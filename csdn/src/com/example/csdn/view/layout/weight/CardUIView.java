package com.example.csdn.view.layout.weight;

import java.util.ArrayList;
import java.util.List;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Scroller;
import android.widget.Toast;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;

public class CardUIView extends FrameLayout {
	private Context mContext;
	private List<View> viewList = new ArrayList<View>();
	private int touch_index = 0;

	// 滑动管理器
	private Scroller mScroller;

	private int mScreenWidth = 0;

	private int mScreenHeigh = 0;
	// 第一次按下距离
	private int mFristDownY = 0;

	private int mCurryY;
	// 偏移量
	private int mScrollY;
	// 是否滑动完成
	private boolean mFinishFlag = false;

	private PointF pointDown = new PointF();
	private PointF pointDownStart = new PointF();

	private int lastTop = 0;

	public CardUIView(Context context) {
		super(context);
		mContext = context;
		initView(context);
	}

	public void setViewList(List<View> viewList) {
		this.viewList = viewList;
		touch_index = this.viewList.size() - 1;
		setupView(this.viewList);
	}

	public void initView(Context mContext) {
		// 这个Interpolator你可以设置别的 我这里选择的是有弹跳效果的Interpolator
		Interpolator polator = new BounceInterpolator();
		mScroller = new Scroller(mContext, polator);

		// 获取屏幕分辨率
		WindowManager wm = (WindowManager) (mContext
				.getSystemService(Context.WINDOW_SERVICE));
		DisplayMetrics dm = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(dm);
		mScreenHeigh = dm.heightPixels;
		mScreenWidth = dm.widthPixels;

	}

	private void setupView(List<View> viewList) {

		this.removeAllViews();
		for (int i = 0; i < viewList.size(); i++) {
			View vthis = viewList.get(i);
			addView(vthis);
		}

	}

	public void startBounceAnim(int startY, int dy, int duration) {
		mScroller.startScroll(0, startY, 0, dy, duration);
		invalidate();
	}

	// measure过程
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		// 设置该ViewGroup的大小
		int width = MeasureSpec.getSize(widthMeasureSpec);
		int height = MeasureSpec.getSize(heightMeasureSpec);
		setMeasuredDimension(width, height);

		int childCount = getChildCount();

		for (int i = 0; i < childCount; i++) {
			View child = getChildAt(i);
			// 设置每个子视图的大小 ， 即全屏
			// child.measure(mScreenWidth, mScreenHeigh);
		}
		
	}

	// layout过程
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub

		int startLeft = 0; // 每个子视图的起始布局坐标
		int startTop = 10; // 间距设置为10px 相当于 android：marginTop= "10px"
		int childCount = getChildCount();

		for (int i = 0; i < childCount; i++) {
			View child = getChildAt(i);
			startTop = startTop + 30;
			child.layout(startLeft, startTop, startLeft + mScreenWidth,
					startTop + mScreenHeigh);

		}
		lastTop = startTop;
		
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		return super.onTouchEvent(event);
	}

	@Override
	public void computeScroll() {

		if (mScroller.computeScrollOffset()) {

			scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
			Log.i("scroller", "getCurrX()= " + mScroller.getCurrX()
					+ "     getCurrY()=" + mScroller.getCurrY()
					+ "  getFinalY() =  " + mScroller.getFinalY());
			// 更新界面
			postInvalidate();
		} else {
			if (mFinishFlag) {
				this.setVisibility(GONE);
			}
		}
	}

	int distanceYTranslate = 0;
	AnimatorSet animatorSet;

	@SuppressLint("NewApi")
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		
		// 字事件
		int action = ev.getAction();
		// requestDisallowInterceptTouchEvent(true);
		switch (action) {
		case MotionEvent.ACTION_DOWN:

			pointDownStart.y = ev.getY();
			distanceYTranslate = 0;
			return true;
		case MotionEvent.ACTION_MOVE:
			 View view = this.getChildAt(touch_index);
			if (pointDown.y >= pointDownStart.y) {
				int yDistance = (int) (ev.getY() - pointDown.y);
				distanceYTranslate += yDistance;
				view.setTranslationY(lastTop + yDistance);
			}

			pointDown.y = ev.getY();
			break;
		case MotionEvent.ACTION_UP:
			 final View view1 = this.getChildAt(touch_index);
			if (distanceYTranslate >= 50) {

				if (animatorSet == null || !animatorSet.isRunning()) {
					animatorSet = new AnimatorSet();
					animatorSet.playTogether(ObjectAnimator.ofFloat(view1,
							"TranslationY", mContext.getResources()
									.getDisplayMetrics().heightPixels));
					animatorSet.addListener(new AnimatorListener() {
						
						@Override
						public void onAnimationStart(Animator arg0) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void onAnimationRepeat(Animator arg0) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void onAnimationEnd(Animator arg0) {
							
							viewList.remove(view1);
							viewList.add(0, view1);
							CardUIView.this.removeView(view1);
							CardUIView.this.addView(view1, 0);
							view1.setTranslationY(0);
							
						}
						
						@Override
						public void onAnimationCancel(Animator arg0) {
							// TODO Auto-generated method stub
							
						}
					});
					animatorSet.setDuration(100);
					animatorSet.start();
				}

			}else{
				animatorSet=new AnimatorSet();
				animatorSet.playTogether(ObjectAnimator.ofFloat(view1,
						"TranslationY", lastTop-view1.getTop()));
				//view1.setTranslationY(lastTop);
				animatorSet.setDuration(200);
				animatorSet.start();
				
			}

		}

		getParent().requestDisallowInterceptTouchEvent(true);

		return super.dispatchTouchEvent(ev);
	}

}
