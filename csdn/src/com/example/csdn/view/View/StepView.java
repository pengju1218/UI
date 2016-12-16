package com.example.csdn.view.View;

import com.example.csdn.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

public class StepView extends View {

	private String[] stepNames = { "设计", "开发", "测试", "验收", "完成" };
	private Context context;
	private int stepLength = 5;
	private int marginLeft = 20;
	private int marginTop = 10;
	private int stepHeight = 10;// 高度
	private int stepBgHeight = 15;// 背景高度

	private float stepPercent = 1.2f;// 进度
	private int diameter = 10;
	private int diameterBg = 15;
	private int colorbg = Color.BLACK;// 背景色
	private int colorfr = Color.YELLOW;// 前景色
	private int colortx = Color.GREEN;// 字体的颜色
	private float textSize=20;//字体大小
	private float maringTxY=40;
	private float maringTxX=5;
	
	/** 步骤的长度 */

	public StepView(Context context) {
		super(context);
		this.context = context;

	}

	public StepView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		TypedArray a = context.obtainStyledAttributes(attrs,     
                R.styleable.stepview_style);     
             
         colortx = a.getColor(R.styleable.stepview_style_step_textColor,     
                0XFFFFFFFF);     
         textSize = a.getDimension(R.styleable.stepview_style_step_textSize, 36);  
         maringTxY = a.getDimension(R.styleable.stepview_style_step_textMargin, 36);  
         
	}

	/**
	 * 获取屏幕的宽度
	 * 
	 * @param context
	 * @return
	 */
	public int getWidth(Context context) {
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);

		int width = wm.getDefaultDisplay().getWidth();

		return width;
	}

	@Override
	protected void onDraw(Canvas canvas) {

		super.onDraw(canvas);
		// 设置画布的背景颜色
		canvas.drawColor(Color.WHITE);
		int width = getWidth(context);
		float rectwidth = width - (marginLeft * 2);

		Log.i("test_width", rectwidth + "");
		// 定义画笔1
		Paint paint = new Paint();
		paint.setStyle(Paint.Style.FILL);
		paint.setColor(colorbg);
		paint.setAntiAlias(true);

		// 定义画笔2
		Paint paint2 = new Paint();
		// 消除锯齿
		paint2.setAntiAlias(true);
		paint2.setStyle(Paint.Style.FILL);
		// 设置画笔的颜色
		paint2.setColor(colorfr);

		// 定义画笔1
		Paint paintText = new Paint();
		paintText.setStyle(Paint.Style.FILL);
		paintText.setColor(colortx);
		paintText.setAntiAlias(true);
		paintText.setTextSize(textSize);

		canvas.drawRect(marginLeft, marginTop, rectwidth + marginLeft,
				marginTop + stepBgHeight, paint);

		float tmp_step = rectwidth / (stepLength - 1);
		Log.i("test_width", tmp_step + "");
		for (int i = 0; i < stepLength; i++) {
			float tmp = stepPercent - i;
			float positionX = marginLeft + (tmp_step * i);
			float positionY = marginTop + (diameter / 2);
			float positionBgY = marginTop + (diameterBg / 2);
			canvas.drawCircle(positionX, positionBgY, diameterBg, paint);
			if (stepPercent >= i) {
				canvas.drawCircle(positionX, positionBgY, diameter, paint2);
				Log.i("test_width3", marginLeft + (tmp_step * i) + "");
			} else {

			}
			float positionX_tx = positionX-(textSize);
			float positionY_tx =positionBgY+maringTxY;
			
			
			canvas.drawText(stepNames[i], positionX_tx, positionY_tx, paintText);
		}
		float stepWid = (stepPercent / (stepLength - 1)) * rectwidth;
		float marginTopfr = marginTop + stepBgHeight - stepHeight;
		canvas.drawRect(marginLeft, marginTopfr, stepWid + marginLeft,
				marginTop + stepHeight, paint2);

	}

	

	public String[] getStepNames() {
		return stepNames;
	}

	public void setStepNames(String[] stepNames) {
		this.stepNames = stepNames;
	}

	

	public void setContext(Context context) {
		this.context = context;
	}

	public int getStepLength() {
		return stepLength;
	}

	public void setStepLength(int stepLength) {
		this.stepLength = stepLength;
	}

	public int getMarginLeft() {
		return marginLeft;
	}

	public void setMarginLeft(int marginLeft) {
		this.marginLeft = marginLeft;
	}

	public int getMarginTop() {
		return marginTop;
	}

	public void setMarginTop(int marginTop) {
		this.marginTop = marginTop;
	}

	public int getStepHeight() {
		return stepHeight;
	}

	public void setStepHeight(int stepHeight) {
		this.stepHeight = stepHeight;
	}

	public int getStepBgHeight() {
		return stepBgHeight;
	}

	public void setStepBgHeight(int stepBgHeight) {
		this.stepBgHeight = stepBgHeight;
	}

	public float getStepPercent() {
		return stepPercent;
	}

	public void setStepPercent(float stepPercent) {
		this.stepPercent = stepPercent;
	}

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public int getDiameterBg() {
		return diameterBg;
	}

	public void setDiameterBg(int diameterBg) {
		this.diameterBg = diameterBg;
	}

	public int getColorbg() {
		return colorbg;
	}

	public void setColorbg(int colorbg) {
		this.colorbg = colorbg;
	}

	public int getColorfr() {
		return colorfr;
	}

	public void setColorfr(int colorfr) {
		this.colorfr = colorfr;
	}

	public int getColortx() {
		return colortx;
	}

	public void setColortx(int colortx) {
		this.colortx = colortx;
	}

	public float getTextSize() {
		return textSize;
	}

	public void setTextSize(float textSize) {
		this.textSize = textSize;
	}

	public float getMaringTxY() {
		return maringTxY;
	}

	public void setMaringTxY(float maringTxY) {
		this.maringTxY = maringTxY;
	}

	public float getMaringTxX() {
		return maringTxX;
	}

	public void setMaringTxX(float maringTxX) {
		this.maringTxX = maringTxX;
	}

	/**
	 * 显示
	 */
	public void show() {
		this.invalidate();
	}

}