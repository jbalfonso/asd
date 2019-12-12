package _01;

import java.util.ArrayList;
/**
 * 
 * @author Juan
 *
 */
public class BarberShop {
	 
	ArrayList<Beard> beardCatalog = new ArrayList<Beard>();
	ArrayList<Beard> beardCutted = new ArrayList<Beard>();
	private Beard returnbeard;
	private int day = 0;
/**
 * This method returns to the Barber the deleted Beard that are in the beardCatalog
 * @return The beard that are deleted of the beardCatalog
 */
	public synchronized Beard getBeard() {
		//if there no are beards in the catalog the thread waits to add beards
		if (beardCatalog.size() <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			//the day goes with each client
			day++;
			//go over each beard and checks if the name equals to the discount of the day
			for (Beard b : beardCatalog) {
				double price = b.getPrice();
				String name = b.getName();
				b.setPrice(discount(price, name));

			}
			
			returnbeard = beardCatalog.remove(0);
			beardCutted.add(returnbeard);
			
			//Shows by console the benefits to the Barber
			System.out.println(benefits());

		}
		return returnbeard;
	}
/**
 * The method sets the beard to the arraylist beardCatalog and notify to wake all other sleeping threads
 * @param beard This is the beard, that choose the Client
 */
	public synchronized void setBeard(Beard beard) {

		beardCatalog.add(beard);

		notifyAll();

	}
/**
 * This method returns the price with the applied discount, if the offer of the day matches
 * @param randomPrice Is the actual price of the beard without discount
 * @param beardname Is the name of the beard, to can check the offers
 * @return The price with the discounted discount
 */
	public double discount(double randomPrice, String beardname) {
		double discount = (randomPrice * 15) / 100;
		double returnPrice = randomPrice;
		if (day == 1 && beardname.equals("Scruff")) {
			returnPrice -= discount;
		} else if (day == 2 && beardname.equals("Stubble")) {
			returnPrice -= discount;
		} else if (day == 3 && beardname.equals("Corporate")) {
			returnPrice -= discount;
		} else if (day == 4 && beardname.equals("Short")) {
			returnPrice -= discount;
		} else if (day == 5 && beardname.equals("Long")) {
			returnPrice -= discount;
		} else if (day == 6 && beardname.equals("Full")) {
			returnPrice -= discount;
		} else if (day == 7 && beardname.equals("Goatee")) {
			returnPrice -= discount;
		}
		return returnPrice;
	}

	/**
	 * This method returns a formated text that says the benefits of the barbers
	 * @return a formatted string with the benefits to the barber
	 */
	public String benefits() {
		double benefits = 0;
		for (Beard b : beardCutted) {
			benefits += b.getPrice();
		}
		return String.format(
				" %n Benefits for the Barber %n" + "Quantity of selled beards: %d %n" + "Benefits: %1.2f %n",
				beardCutted.size(), benefits);
	}

}
