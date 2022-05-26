package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ColorEnum {
	MARROM("12"),
	BRANCO("11"),
	PRETO("10");
	
	
	public String key;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	ColorEnum(String key){
		this.key = key;
	}
	private static final Map<String, ColorEnum> lookup = new HashMap<String, ColorEnum>();
	static {
		for(ColorEnum x : EnumSet.allOf(ColorEnum.class))
			lookup.putIfAbsent(x.getKey(), x);
	}
	public static ColorEnum get(String key) {
		return lookup.get(key);
		
	}
}
