package _01;

import java.util.ArrayList;
/**
 * 
 * @author Juan
 *
 */
public class Client extends Thread {
	//This is the shared resource BarberShop
	private BarberShop bShop;
	//This is the catalog of types of beard to choose
	private ArrayList<Beard> beard = new ArrayList<Beard>();
/**
 * Builds a new object client
 * @param bShop2 is the shared resource, to know the shared resource
 * @param beard this is an arraylist with the catalog of beards to choose
 */
	public Client(BarberShop bShop2, ArrayList<Beard> beard) {
		this.bShop = bShop2;
		this.beard = beard;
	}
/**
 * This is the method that run the Thread
 */
	public void run() {
		//The random time between 5 and 20 that the threads sleeps
		int randtime = (int) (Math.random() * 16 + 5);
		try {
			//The thread sleeps
			Thread.sleep(randtime * 1000);
			//random number between 0 to 6 to choose a Beard
			int numBeard = (int) (Math.random() * 7);
			//call the Barbershop method setBeard, that sets the Beard in an arraylist
			bShop.setBeard(beard.get(numBeard));

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
