package com.koatchy.configGenerator.model;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class KeyValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String Key;
	private String Value;

	public KeyValue() {
		super();		
	}
	
	public KeyValue(String key, String value) {
		super();
		Key = key;
		Value = value;
	}
	
	public String getKey() {
		return Key;
	}
	public void setKey(String key) {
		Key = key;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	
	@Override
	public String toString() {
		return "KeyValue [Key=" + Key + ", Value=" + Value + "]";
	}
	
}
