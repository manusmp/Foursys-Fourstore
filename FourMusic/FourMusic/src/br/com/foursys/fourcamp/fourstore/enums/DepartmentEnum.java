package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum DepartmentEnum {
	ELETRICO("30"),
	ACUSTICO("31");
	
	
	public String key;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	DepartmentEnum(String key){
		this.key = key;
	}
	private static final Map<String, DepartmentEnum> lookup = new HashMap<String, DepartmentEnum>();
	static {
		for(DepartmentEnum x : EnumSet.allOf(DepartmentEnum.class))
			lookup.putIfAbsent(x.getKey(), x);
	}
	public static DepartmentEnum get(String key) {
		return lookup.get(key);
		
	}
}
