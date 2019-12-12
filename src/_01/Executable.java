package _01;

import java.util.ArrayList;
/**
 * 
 * @author Juan
 *
 */
public class Executable {
	public static void main(String[] args) {
		
		ArrayList<Client> clients = new ArrayList<Client>();
		ArrayList<Beard> beardsCatalog = new ArrayList<Beard>();
		Beard beard;
		
		//number of customers to choose a beard
		int numberCustomers = 6;

		BarberShop bShop = new BarberShop();
		Barber barber1 = new Barber(bShop);
		
		//add a beard on a list of beards with a random price 
		
		beardsCatalog.add(beard = new Beard("Scruff", (int) (Math.random() * 21 + 5)));
		beardsCatalog.add(beard = new Beard("Stubble", (int) (Math.random() * 21 + 5)));
		beardsCatalog.add(beard = new Beard("Corporate", (int) (Math.random() * 21 + 5)));
		beardsCatalog.add(beard = new Beard("Short", (int) (Math.random() * 21 + 5)));
		beardsCatalog.add(beard = new Beard("Long", (int) (Math.random() * 21 + 5)));
		beardsCatalog.add(beard = new Beard("Full", (int) (Math.random() * 21 + 5)));
		beardsCatalog.add(beard = new Beard("Goatee", (int) (Math.random() * 21 + 5)));
		
		//Sets a name to the Barber and runs the thread
		barber1.setName("barber1");
		barber1.start();
		
		//Runs the clients and sets a name for each thread
		
		for (int i = 1; i < numberCustomers; i++) {
			Client clnt = new Client(bShop, beardsCatalog);
			clnt.setName("Client: " + i);
			clnt.start();
			clients.add(clnt);

			
		}
		
		//joins each thread to wait for each one
		try {
			for (Client c : clients) {
				c.join();

			}
			barber1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
