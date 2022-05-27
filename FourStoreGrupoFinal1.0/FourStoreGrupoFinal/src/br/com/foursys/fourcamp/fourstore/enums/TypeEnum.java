package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum TypeEnum {
	VIOLAO("01"),
	VIOLINO("02"),
	SAXOFONE("03"),
	FLAUTA("04"),
	BATERIA("05"),
	PIANO("06");
	
	public String key;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	TypeEnum(String key){
		this.key = key;
	}
	private static final Map<String, TypeEnum> lookup = new HashMap<String, TypeEnum>();
	static {
		for(TypeEnum x : EnumSet.allOf(TypeEnum.class))
			lookup.putIfAbsent(x.getKey(), x);
	}
	public static TypeEnum get(String key) {
		return lookup.get(key);
		
	}
	
}