package com.example.csdn.view.Text;

import android.content.Context;  
import android.graphics.Canvas;  
import android.graphics.Paint;  
import android.util.AttributeSet;  
import android.widget.TextView;  
/** 
 * 需求描述: 
 * TextView跑马灯的实现 
 *  
 * 实现原理: 
 * 通过不断的scrollTo()显示View中不同坐标处的内容 
 *  
 *遇到的问题 
 *1 注意scrollTo(int x, int y) 
 *  移动View中内容,比如此处TextView中的文字. 
 *  x the x position to scroll to 
 *  y the y position to scroll to 
 *   
 *2 scrollTo(int x, int y)的坐标问题 
 *  参考资料: 
 *  http://www.open-open.com/lib/view/open1328834050046.html 
 *  个人理解: 
 *  该坐标为View中的内容的坐标.该坐标的起始点虽然在内容的左上角 
 *  但是Y轴的正向是竖直向上的,X轴水平向右. 
 *  该理解待于进一步验证. 
 *   
 */  
public class MarqueeText extends TextView implements Runnable {  
    private int contentWidth=0;  
    private int scrollToX=0;  
    private boolean isStop=false;  
    private boolean isRun=true;  
    private boolean isMeasureContentWidth=false;  
    public MarqueeText(Context context, AttributeSet attrs) {  
        super(context, attrs);  
    }  
  
    @Override  
    protected void onDraw(Canvas canvas) {  
        super.onDraw(canvas);  
        if (!isMeasureContentWidth) {  
            //获取文字长度  
            Paint paint=this.getPaint();  
            String content=this.getText().toString();  
            contentWidth=(int) paint.measureText(content);  
            isMeasureContentWidth=true;  
        }  
    }  
    public void run() {  
        if (isRun) {  
            if (scrollToX>=contentWidth) {  
                //重新开始  
                scrollToX=-150;  
            }  
            scrollTo(scrollToX, 0);  
            scrollToX=scrollToX+5;  
            postDelayed(this, 150);  
        }  
          
    }  
  
    // 点击开始,执行线程  
    public void startScroll() {  
        post(this);  
    }  
  
    // 点击暂停  
    public void pauseScroll() {  
        isRun=false;  
    }  
  
    // 点击重新开始  
    public void restartScroll() {  
        isRun=true;  
        scrollToX=0;  
        startScroll();  
    }  
  
}  