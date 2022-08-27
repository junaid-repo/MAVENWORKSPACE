package excelProject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		List<Integer> linkedL = new LinkedList<>();
		List<Integer> arrayL = new ArrayList<>();
		long lSt = System.currentTimeMillis();
		for (int i = 0; i < 50000000; i++) {
			linkedL.add(i);
		}
		System.out.println(System.currentTimeMillis() - lSt);

		long aSt = System.currentTimeMillis();
		for (int i = 0; i < 50000000; i++) {
			arrayL.add(i);
		}
		System.out.println(System.currentTimeMillis() - aSt);
		// System.out.println(linkedL);

	}

}
