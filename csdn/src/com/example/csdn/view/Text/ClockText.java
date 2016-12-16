package com.example.csdn.view.Text;

import java.util.Calendar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;

import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;

public class ClockText  extends TextView{ 
  
     Calendar mCalendar; 
        @SuppressWarnings("FieldCanBeLocal") // We must keep a reference to this observer     
        private FormatChangeObserver mFormatChangeObserver; 
  
        private Runnable mTicker; 
        private Handler mHandler; 
  
        private boolean mTickerStopped = false; 
  
        private String mFormat; 
  
        public ClockText(Context context) { 
            super(context); 
            initClock(); 
        } 
  
        public ClockText(Context context, AttributeSet attrs) { 
            super(context, attrs); 
            initClock(); 
        } 
  
        private void initClock() { 
            if (mCalendar == null) { 
                mCalendar = Calendar.getInstance(); 
            } 
  
            mFormatChangeObserver = new FormatChangeObserver(); 
            getContext().getContentResolver().registerContentObserver( 
                    Settings.System.CONTENT_URI, true, mFormatChangeObserver); 
  
            setFormat(); 
        } 
  
        @Override
        protected void onAttachedToWindow() { 
            mTickerStopped = false; 
            super.onAttachedToWindow(); 
            mHandler = new Handler(); 
  
            /** 
             * requests a tick on the next hard-second boundary 
             */
            mTicker = new Runnable() { 
                public void run() { 
                    if (mTickerStopped) return; 
                    mCalendar.setTimeInMillis(System.currentTimeMillis()); 
                    setText(DateFormat.format(mFormat, mCalendar)); 
                    invalidate(); 
                    long now = SystemClock.uptimeMillis(); 
                    long next = now + (1000 - now % 1000); 
                    mHandler.postAtTime(mTicker, next); 
                } 
            }; 
            mTicker.run(); 
        } 
  
        @Override
        protected void onDetachedFromWindow() { 
            super.onDetachedFromWindow(); 
            mTickerStopped = true; 
        } 
  
        private void setFormat() { 
            mFormat = mFormat; 
        } 
        public void setFormat(String format){ 
            this.mFormat = format; 
        } 
        private class FormatChangeObserver extends ContentObserver { 
            public FormatChangeObserver() { 
                super(new Handler()); 
            } 
  
            @Override
            public void onChange(boolean selfChange) { 
                setFormat(); 
            } 
        } 
  
        @SuppressLint("NewApi")
		@Override
        public void onInitializeAccessibilityEvent(AccessibilityEvent event) { 
            super.onInitializeAccessibilityEvent(event); 
            //noinspection deprecation             event.setClassName(ClockText.class.getName()); 
        } 
  
        @SuppressLint("NewApi")
		@Override
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) { 
            super.onInitializeAccessibilityNodeInfo(info); 
            //noinspection deprecation             info.setClassName(ClockText.class.getName()); 
        } 
}