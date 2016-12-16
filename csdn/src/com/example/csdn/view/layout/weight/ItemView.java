package com.example.csdn.view.layout.weight;

import com.example.csdn.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class  ItemView extends LinearLayout {
 
    private ImageView imageView;
    private TextView  textView;
     
    public ItemView(Context context) {
        super(context);
        init(context);
    }
    public ItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        init(context);
    }
    
    
    private void init(Context context) {
    	 LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         inflater.inflate(R.layout.index_item, this);
         imageView=(ImageView) findViewById(R.id.image);
         textView=(TextView)findViewById(R.id.name);

	}
    
  
    /** 
     * 设置图片资源 
     */ 
    public void setImageResource(int resId) {  
        imageView.setImageResource(resId);  
    }  
   
    /** 
     * 设置显示的文字 
     */ 
    public void setText(String text) {  
        textView.setText(text);  
    }  
 
    
    public String getText() {  
        return textView.getText().toString();  
    }  
    
    
    public void setImageVisiable(int b){
    	imageView.setVisibility(b);
    }
    
    
    private String item_id;
    private String key;
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

	
    
    
    
    
    
    
}