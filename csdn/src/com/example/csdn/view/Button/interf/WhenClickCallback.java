package com.example.csdn.view.Button.interf;

/***
 * 
 * 预防多个波纹效果的按钮同时点击自动触发多个点击事件的问题
 * @author ciyo
 *
 */
public interface WhenClickCallback {
	public abstract boolean performClick(int id) ;
	public abstract void doneClick() ;
	public abstract int getState();
}
