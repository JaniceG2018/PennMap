package main;

/**
 * This class models
 * @author calchen
 *
 */
public class Pair {
	
	/**
	 * 
	 */
	private double key;
	
	/**
	 * 
	 */
	private String value;
	
	/**
	 * Copy constructor of this class, which initializes key and value to default values
	 * @param key
	 * @param value
	 */
	public Pair(double key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * Getter for the key
	 * @return the key
	 */
	public double getKey() {
		return key;
	}

	/**
	 * Setter for the key
	 * @param key the new key
	 */
	public void setKey(double key) {
		this.key = key;
	}	
	
	/**
	 * Getter for the value
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Setter for the value
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}
} // ac