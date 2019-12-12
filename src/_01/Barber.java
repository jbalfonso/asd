package _01;
/**
 * 
 * @author Juan
 *
 */
public class Barber extends Thread {
	private BarberShop bShop;
/**
 * Builds the Barber
 * @param bShop2 this is the shared resource BarberShop
 */
	public Barber(BarberShop bShop2) {
		this.bShop = bShop2;
	}
/**
 * This is the method that runs the thread
 */
	public void run() {
		while (true) {
			//the random time between 3 to 6 seconds to wait
			int randtime = (int) (Math.random() * 4 + 3);
			try {
				//The thread sleeps
				Thread.sleep(randtime * 1000);
				//calls to the shared resource method getBeard
				bShop.getBeard();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
