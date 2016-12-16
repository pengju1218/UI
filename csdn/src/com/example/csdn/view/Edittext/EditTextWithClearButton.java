package com.example.csdn.view.Edittext;


import org.apache.commons.lang.StringUtils;

import  com.example.csdn.R;


import android.content.Context;
import android.content.res.TypedArray; 
import android.text.Editable; 
import android.text.TextWatcher; 
import android.util.AttributeSet;
import android.view.LayoutInflater; 
import android.view.View; 
import android.widget.EditText; 
import android.widget.ImageButton; 
import android.widget.LinearLayout; 
 /** 
 * 带清除按钮的输入框 
 * @author WWF 
 */ public class EditTextWithClearButton extends LinearLayout{ 
      
    private EditText editText; 
    private ImageButton clearImageButton; 
  
    public EditTextWithClearButton(Context context) { 
        super(context); 
    } 
      
    public EditTextWithClearButton(Context context,AttributeSet attrs){ 
        super(context, attrs); 
        init(context,attrs); 
    } 
      
    /** 
     * 初始化 
     */
    public void init(Context context,AttributeSet attrs){ 
        View view = LayoutInflater.from(context).inflate(R.layout.weight_edit_with_clear, this, true); 
        editText = (EditText) view.findViewById(R.id.et); 
        clearImageButton = (ImageButton) view.findViewById(R.id.clear_ib); 
        clearImageButton.setOnClickListener(new OnClickListener() { 
            @Override
            public void onClick(View v) { 
                editText.setText(""); 
            } 
        }); 
        editText.addTextChangedListener(new TextWatcher() { 
              
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { 
                if (s.length() > 0) { 
                    clearImageButton.setVisibility(View.VISIBLE); 
                } else { 
                    clearImageButton.setVisibility(View.GONE); 
                } 
            } 
              
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, 
                    int after) { 
                  
            } 
            @Override
            public void afterTextChanged(Editable s) { 
                  
            } 
        }); 
        //将属性值设置到控件中        
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.EditTextWithClearBitton); 
        CharSequence hint = a.getText(R.styleable.EditTextWithClearBitton_hint); 
        CharSequence text = a.getText(R.styleable.EditTextWithClearBitton_text); 
        if (text!=null&&!StringUtils.isEmpty(text.toString().trim())) { 
            editText.setText(text); 
            //设置光标位置         
            editText.setSelection(text.length()); 
            this.clearImageButton.setVisibility(View.VISIBLE); 
        }else { 
            if (hint!=null&&!StringUtils.isEmpty(hint.toString().trim())) { 
                editText.setHint(hint); 
            } 
        } 
        a.recycle(); 
    } 
      
    /** 
     * 获得输入的值 
     * @return 
     */
    public String getText(){ 
        return this.editText.getText().toString(); 
    } 
      
    /** 
     * 设置值 
     * @param text 
     */
    public void setText(String text){ 
        this.editText.setText(text); 
    } 
      
    /** 
     * 设置默认值 
     * @param hint 
     */
    public void setHint(String hint){ 
        this.editText.setHint(hint); 
    } 
      
    /** 
     * 获得输入框控件 
     * @return 
     */
    public EditText getEditText(){ 
        return this.editText; 
    } 
      
    /** 
     * 获得消除按钮 
     * @return 
     */
    public ImageButton getClearImageButton(){ 
        return this.clearImageButton; 
    } 
}