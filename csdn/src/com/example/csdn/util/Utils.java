package com.example.csdn.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import  com.example.csdn.R;


import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Utils {
        public static void setListViewHeightBasedOnChildren(ListView listView) { 
            ListAdapter listAdapter = listView.getAdapter(); 
            if (listAdapter == null ) { 
                    // pre-condition 
                    return; 
            } 
            
            Log.e("", "listAdapter.getCount() = " + listAdapter.getCount());
      
            int totalHeight = 0; 
            int tmp = 0;
            for (int i = 0; i < listAdapter.getCount(); i++) { 
                    View listItem = listAdapter.getView(i, null, listView); 
                    listItem.measure(0, 0); 
                    totalHeight += listItem.getMeasuredHeight();   
                    tmp = listItem.getMeasuredHeight();
            } 
            totalHeight += 10;
            ViewGroup.LayoutParams params = listView.getLayoutParams(); 
            params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1)); 
            listView.setLayoutParams(params); 
        } 
        
        
        

    	public static String getAssetsString(Context context,String fileName){
    		StringBuffer sb = new StringBuffer();
    		try {
    			AssetManager am = context.getAssets();
    			InputStream in = am.open(fileName);
    			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    			String line;
    			while((line = reader.readLine())!=null){
    				line += ("\n");
    				sb.append(line);
    			}
    			reader.close();
    			in.close();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		return sb.toString();
    	}
    
} 