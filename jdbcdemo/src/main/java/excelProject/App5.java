package excelProject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Hello world!
 *
 */
public class App5 implements Runnable {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		// Create a HashTable to store
		// String values corresponding to integer keys
		Hashtable<Integer, String> hm = new Hashtable<Integer, String>();

		// Input the values
		hm.put(1, "Geeks");
		hm.put(12, "forGeeks");
		hm.put(15, "A computer");
		hm.put(3, "Portal");

		App5 td = new App5();
		Thread thread = new Thread(td);
		thread.start();

		// Printing the Hashtable
		// System.out.println(hm);
		for (int i = 0; i < 30; i++) {

			try {
				thread.sleep(800);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.print(i + "  ");
		}
	}

	public void run() {

		App5 td = new App5();
		Thread thread = new Thread(td);
		
		try {
			
			for (int j = 1; j < 50; j++) {
				thread.sleep(300);
				System.out.println("INside run method " + j);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
