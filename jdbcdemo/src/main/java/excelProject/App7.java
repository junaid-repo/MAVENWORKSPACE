package excelProject;

import org.json.JSONObject;

/**
 * Hello world!
 *
 */
public class App7 {
	// EmployeeDetailsRequest emp = new EmployeeDetailsRequest();

	public static void main(String[] args) {
		String st1 = "";
		String st2 = "";
		String pin = "400001";
		String office = "Town Hall S.O (Mumbai)";
		String office_type = "S.O";
		String delivery = "Non-Delivery";
		String division = "Mumbai  South";
		String region = "Mumbai";
		String circle = "Maharashtra";
		String taluk = "Mumbai";
		String district = "Mumbai";
		String state_id = "19";
		String phone = "022-22660701";
		String related_suboffice = "Not Available";
		String related_headoffice = "Mumbai G.P.O. ";
		String longitude = "Not Available";
		String latitude = "Not Available";

		String paramName = "";
		String paramVal = "";
		String longString = "[{\"train_num\":18626,\"name\":\"Hatia - Patna Super Express\",\"train_from\":\"HTE\",\"train_to\":\"PNBE\",\"data\":{\"id\":\"1359\",\"days\":{\"Fri\":1,\"Mon\":1,\"Sat\":1,\"Sun\":1,\"Thu\":1,\"Tue\":1,\"Wed\":1},\"to_id\":\"332\",\"classes\":[\"II\",\"CC\"],\"from_id\":\"385\",\"arriveTime\":\"15:40 \",\"departTime\":\"06:10\"}}]\n"
				+ "";
		
		System.out.println();
		
		String[] st = longString.split("},");

		for (int i = 0; i < st.length; i++) {
			st1 = st[i];

			StringBuffer stb = new StringBuffer(st1);
			st2 = st1.replace("[", "");
			st2 = st2.replace("{", "");
			st2 = st2.replace("}]", "");
			// System.out.println(st2);
			System.out.println("###################################################################");
			String[] innerSt = st2.split(",");
			for (int j = 0; j < innerSt.length; j++) {
				// System.out.println(innerSt[j]);

				String[] inst = innerSt[j].split(":");
				for(int k=0; k<inst.length;k++) {
					System.out.println(inst[k]);
				}
				

				/*
				 * paramName = inst[0].replace('"', ' '); paramVal = inst[1].replace('"', ' ');
				 */
				/*
				 * if (paramName.trim().equals("pin")) pin = paramVal.trim();
				 * 
				 * else if (paramName.trim().equals("office")) office = paramVal.trim(); else if
				 * (paramName.trim().equals("office_type")) office_type = paramVal.trim(); else
				 * if (paramName.trim().equals("delivery")) delivery = paramVal.trim(); else if
				 * (paramName.trim().equals("division")) division = paramVal.trim(); else if
				 * (paramName.trim().equals("region")) region = paramVal.trim(); else if
				 * (paramName.trim().equals("circle")) circle = paramVal.trim(); else if
				 * (paramName.trim().equals("taluk")) taluk = paramVal.trim(); else if
				 * (paramName.trim().equals("district")) district = paramVal.trim(); else if
				 * (paramName.trim().equals("state_id")) state_id = paramVal.trim(); else if
				 * (paramName.trim().equals("phone")) phone = paramVal.trim(); else if
				 * (paramName.trim().equals("related_suboffice")) related_suboffice =
				 * paramVal.trim(); else if (paramName.trim().equals("longitude")) longitude =
				 * paramVal.trim(); else if (paramName.trim().equals("latitude")) latitude =
				 * paramVal.trim();
				 */
			}

			/*
			 * System.out.println(pin + "," + pin + "," + office + "," + office_type + "," +
			 * delivery + "," + division + "," + region + "," + circle + "," + taluk + "," +
			 * district + "," + state_id + "," + phone + "," + related_suboffice + "," +
			 * longitude + "," + latitude);
			 */

			// System.out.println(stb);
		}
		/*
		 * List<Integer> list1 = Arrays.asList(43, 66, 45, 75, 24, 63); Integer sum =
		 * list1.stream().filter(x -> x % 2 == 0).reduce(0, Integer::sum);
		 * 
		 * System.out.println(sum);
		 * 
		 * List<String> list2 = Arrays.asList("Rowan", "Ronan", "Ronald", "Ron");
		 * 
		 * list2.stream().filter(i -> i.startsWith("Ro")).map(i -> i.replace("Ro",
		 * "Do")).forEach(System.out::println);
		 */
	}

}
