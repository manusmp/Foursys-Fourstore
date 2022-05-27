package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum CategoryEnum {
	SOPRO("70"),
	CORDA("71"),
	PERCURSSÃO("72");
	
	public String key;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	CategoryEnum(String key){
		this.key = key;
	}
	private static final Map<String, CategoryEnum> lookup = new HashMap<String, CategoryEnum>();
	static {
		for(CategoryEnum x : EnumSet.allOf(CategoryEnum.class))
			lookup.putIfAbsent(x.getKey(), x);
	}
	public static CategoryEnum get(String key) {
		return lookup.get(key);
		
	}
}
