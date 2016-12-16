package com.example.csdn.view.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.csdn.R;

/**
 * author : stone
 * email  : aa86799@163.com
 * time   : 15/7/28 11 01
 */
public class GuaView extends View {

    private Bitmap mBitmap; //遮盖的图层
    private Canvas mCanvas; //绘制遮盖图层
    private Paint mOuterPaint;
    private Path mPath;
    private float mLastX;
    private float mLastY;

    private Bitmap mCoverBitmap; //遮盖图
    private int mWidth, mHeight;
    private Paint mInnerPaint;
    private String mInfo;


    public GuaView(Context context) {
        this(context, null);
    }

    public GuaView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        mPath = new Path();
        mOuterPaint = new Paint();
        mInnerPaint = new Paint();
        mCoverBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ggk_bg);

        mInfo = "￥ 5 0 0";
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = mCoverBitmap.getWidth();
        mHeight = mCoverBitmap.getHeight();
        setMeasuredDimension(mWidth, mHeight);

        mBitmap = Bitmap.createBitmap(mWidth, mHeight, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
        mCanvas.drawBitmap(mCoverBitmap, 0, 0, null);

        setOuterPaint();
        setInnerPaint();

    }

    private void setInnerPaint() {
        mInnerPaint.setColor(Color.RED);
        mInnerPaint.setStyle(Paint.Style.STROKE);
        mInnerPaint.setStrokeCap(Paint.Cap.ROUND);
        mInnerPaint.setStrokeJoin(Paint.Join.ROUND);
        mInnerPaint.setAntiAlias(true);
        mInnerPaint.setDither(true); //防抖
        mInnerPaint.setStrokeWidth(5);
        mInnerPaint.setTextSize(100);
        mInnerPaint.setTextAlign(Paint.Align.CENTER);
    }

    private void setOuterPaint() {
        mOuterPaint.setColor(Color.GREEN);
        mOuterPaint.setStyle(Paint.Style.STROKE);
        mOuterPaint.setStrokeCap(Paint.Cap.ROUND);
        mOuterPaint.setStrokeJoin(Paint.Join.ROUND);
        mOuterPaint.setAntiAlias(true);
        mOuterPaint.setDither(true); //防抖
        mOuterPaint.setStrokeWidth(20);
    }

    @Override  //Path
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastX = x;
                mLastY = y;
                mPath.moveTo(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                float deltaX = Math.abs(x - mLastX);
                float deltaY = Math.abs(y - mLastY);
                if (deltaX > 5 || deltaY > 5) {
                    mPath.lineTo(x, y);
                }
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();//调用onDraw
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.parseColor("#bbbbbb")); //背景底色  灰色
        canvas.drawText(mInfo, mWidth / 2, mHeight / 4 * 3, mInnerPaint); //绘制文本
        canvas.drawBitmap(mBitmap, 0, 0, null); //绘制mBitmap   这是一个可变的bitmap，通过mCanvas绘制，首先绘制了mCoverBitmap
        drawPath();

    }

    private void drawPath() {
        //使用该mode：dst和src相交后， 只保留dst，且除去相交的部份
        mOuterPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        mCanvas.drawPath(mPath, mOuterPaint);
    }
}

