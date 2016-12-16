package com.example.csdn.view.Button;

import com.example.csdn.view.Button.interf.WhenClickCallback;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/****
 *需要不同波纹效果的控件， 将父类替换成你想要的控件便可
 * @author ciyo
 *
 */
public class WaterButton extends Button{

	private float centerX , centerY ;
	private float mRevealRadius = 1 , maxRadius;
	private Paint mPaint ;
	private int count = 1;
	private WhenClickCallback l ; 
	
	public WaterButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mPaint = new Paint() ;
		mPaint.setColor(Color.argb(88, 73, 57, 0xdc));
		mPaint.setAntiAlias(true) ;
	}
	public void setWaterColor(int color){
		mPaint.setColor(color) ; 
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(l!=null)
		{
			if(l.getState() == 0){
				l.performClick(getId()) ;
			}
			else if(l.getState() != getId()){
				return false ;
			}
		}
		if(event.getAction() == MotionEvent.ACTION_UP&&count ==1){
			centerX = event.getX() ;
			centerY = event.getY() ;
			mRevealRadius = 1 ;
			float maxX = Math.max(centerX, getWidth() - centerX	);
			float maxY = Math.max(centerY, getHeight() - centerY	);
			maxRadius = (float) Math.sqrt(maxX*maxX + maxY*maxY) ;
			l.doneClick() ;
		}
		else if(event.getAction() == MotionEvent.ACTION_CANCEL){
			l.doneClick() ; 
		}
		return super.onTouchEvent(event);
	}

	public WaterButton(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	public WaterButton(Context context) {
		this(context , null);
	}
	public void registerCallback(WhenClickCallback l) {
		this.l = l;
	}
	@Override
	public boolean performClick(){
		{
			invalidate();
		}
		return false ;
	}
	@Override
	protected void dispatchDraw(Canvas canvas) {
		super.dispatchDraw(canvas);
		int previewCount = count - 1  ;
		if(mRevealRadius -previewCount*previewCount> maxRadius){
			if(count !=1){
				count = 1 ;
				invalidate() ;
				super.performClick() ;
				if(l!=null){
					l.doneClick() ;
				}
			}
			return ;
		}
	    canvas.save();  
	    canvas.clipRect(0	, 0, getWidth()	, getHeight());  
	    canvas.drawCircle(centerX, centerY, mRevealRadius , mPaint);  
	    canvas.restore();  
	    mRevealRadius += count*count ;
	    count ++ ;
	    postInvalidateDelayed(20);
	}
}
