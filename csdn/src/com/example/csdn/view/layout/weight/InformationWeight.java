package com.example.csdn.view.layout.weight;



import  com.example.csdn.R;

import android.content.Context;  
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.util.AttributeSet;  
import android.view.LayoutInflater;  
import android.widget.EditText;
import android.widget.ImageView;  
import android.widget.LinearLayout;  
import android.widget.TextView;  
  
public class InformationWeight extends LinearLayout {  
  
	public EditText name;  
	public EditText phone;  
	public EditText address;  
  
   public InformationWeight(Context context) {  
        this(context, null);  
    }
 
    public InformationWeight(Context context, AttributeSet attrs) {  
        super(context, attrs);  
       // 导入布局  
        LayoutInflater.from(context).inflate(R.layout.infomation_weight, this, true);  
        name = (EditText) findViewById(R.id.name);  
        phone = (EditText) findViewById(R.id.phone);  
        address = (EditText) findViewById(R.id.address); 

    }

    
    public void init(){
    	this.setOrientation(LinearLayout.VERTICAL);  
    	this.setBackgroundColor(Color.WHITE);
    }
    
	public String getName(){
	     return	    name.getText().toString();  
	}
   
	public String getPhone(){
		  return	phone.getText().toString();  
	}
	
	public String getAddress(){
		  return	address.getText().toString();  
	}
}  