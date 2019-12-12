package _01;
/**
 * 
 * @author Juan
 *
 */
public class Beard {
	
	private String name;
	private double price;
	
/**
 * Builds the object Beard
 * @param name The name of the Beard
 * @param price The price of the Beard
 */
	public Beard(String name, double price) {
		this.name = name;
		this.price = price;

	}
/**
 * Returns the price of the beard
 * @return a type double valor that are the price of the beard
 */
	public double getPrice() {
		return price;
	}
/**
 * Sets a new price for the Beard
 * @param price Sets the double parameter for the new price of the beard
 */
	public void setPrice(double price) {
		this.price = price;
	}
/**
 * Returns the name of the beard
 * @return returns a type string valor that are the value for the name of the beard
 */
	public String getName() {
		return name;
	}


}
