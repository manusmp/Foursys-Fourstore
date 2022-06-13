package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum SizeEnum {
	ADULTO("90"),
	KIDS("91");
	
	
	public String key;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	SizeEnum(String key){
		this.key = key;
	}
	private static final Map<String, SizeEnum> lookup = new HashMap<String, SizeEnum>();
	static {
		for(SizeEnum x : EnumSet.allOf(SizeEnum.class))
			lookup.putIfAbsent(x.getKey(), x);
	}
	public static SizeEnum get(String key) {
		return lookup.get(key);
		
	}
}
