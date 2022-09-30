package excelProject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App5 implements Runnable {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		String megaData = "me##Hi saima... hum nemat&&her##hi nemat... kaise ho?&&me##sab badhiya...school jaa rhi ho?&&her##abhi toh chutti chal rha hai... exam khatm hua tha&&me##hm logo ko v durga puja ka chutti hai... exam uske baad hoga&&me##tm logo ka kitna dinn chutti milta hai?&&her##almost 10 dinn ka. aur tm logo ko?&&her##almost 10 dinn ka. aur tm logo ko?&&me##almost 10 dinn ka. aur tm logo ko?&&me##hum logo ka v 10 din hai...lakin Sunday mila k&&me##almost 10 dinn ka. aur tm logo ko?&&me##almost 10 dinn ka. aur tm logo ko?&&me##almost 10 dinn ka. aur tm logo ko?&&me##almost 10 dinn ka. aur tm logo ko?&&me##almost 10 dinn ka. aur tm logo ko?&&me##almost 10 dinn ka. aur tm logo ko?&&me##almost 10 dinn ka. aur tm logo ko?&&me##hum logo ka v 10 din hai...lakin Sunday mila k&&me##hum logo ka v 10 din hai...lakin Sunday mila k";

		// List<Map> superList = new ArrayList<>();
		List<Map> listOfMaps = new ArrayList<>();

		String megaDataArr[] = megaData.split("~~");
		for (int i = 0; i < megaDataArr.length; i++) {
			// System.out.println(megaDataArr[i]);

			String dataArr[] = megaDataArr[i].split("&&");

			Map<String, String> retMap = new HashMap<>();
			for (int j = 0; j < dataArr.length; j++) {

				// System.out.println(tempData);

				String arr[] = dataArr[j].split("##");

				if (arr[0] != null && arr[1] != null)

					retMap.put(arr[1], arr[0]);
				// System.out.println(retMap);

			}
			listOfMaps.add(retMap);
			// System.out.println(listOfMaps);
			// superList.add(listOfMaps);
		}
		// System.out.println(superList);

		// return listOfMaps;

		System.out.println(listOfMaps);
		String json = new ObjectMapper().writeValueAsString(listOfMaps);
		System.out.println(json);

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
