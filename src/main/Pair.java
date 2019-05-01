package main;

public class Pair {
	
	private String value;
	private double key;
	
	public Pair(double key,String val) {
		this.value = val;
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public double getKey() {
		return key;
	}

	public void setKey(double key) {
		this.key = key;
	}	
}