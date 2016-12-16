package com.example.csdn.view.layout.weight;


import  com.example.csdn.R;

import android.content.Context;  
import android.util.AttributeSet;  
import android.view.LayoutInflater;  
import android.widget.EditText;
import android.widget.ImageView;  
import android.widget.LinearLayout;  
import android.widget.TextView;  
  
public class LoginWeight extends LinearLayout {  
  
	public EditText name;  
	public EditText pass;  
  
   public LoginWeight(Context context) {  
        this(context, null);  
    }
 
    public LoginWeight(Context context, AttributeSet attrs) {  
        super(context, attrs);  
       // 导入布局  
        LayoutInflater.from(context).inflate(R.layout.login_weight, this, true);  
        name = (EditText) findViewById(R.id.namevalue);  
        pass = (EditText) findViewById(R.id.passvalue);  
        

    }

	public String getName(){
	  return	name.getText().toString();  
	}
   
	public String getPass(){
		  return	pass.getText().toString();  
	}
}  