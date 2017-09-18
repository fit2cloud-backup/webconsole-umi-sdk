package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OAuth20Profile {
	
	private String name;
	private Map<String, List<Object>> attributes = new HashMap<String, List<Object>>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Map<String, List<Object>> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, List<Object>> attributes) {
		this.attributes.putAll(attributes);
	}
	
	

}
