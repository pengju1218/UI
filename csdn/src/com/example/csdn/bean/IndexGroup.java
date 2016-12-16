package com.example.csdn.bean;

import java.util.List;
import java.util.Map;

public class IndexGroup {

	private String lv1;
	
	private List<String> lv2;
	
	private Map<String ,List<ItemBean>> maps;

	public String getLv1() {
		return lv1;
	}

	public void setLv1(String lv1) {
		this.lv1 = lv1;
	}

	public List<String> getLv2() {
		return lv2;
	}

	public void setLv2(List<String> lv2) {
		this.lv2 = lv2;
	}

	public Map<String, List<ItemBean>> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, List<ItemBean>> maps) {
		this.maps = maps;
	}
	

}
