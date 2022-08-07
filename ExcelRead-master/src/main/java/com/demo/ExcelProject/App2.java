package com.demo.ExcelProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		String newSt = "";
		newSt = newSt.substring(0, newSt.length() - 3);
		System.out.println(newSt);
		String masterQuery="";

		String masterData[] = newSt.split("~~~");

		for (int j = 0; j < masterData.length; j++) {

			String a = masterData[j];
			//System.out.println(a);

			// a = "JOB_HISTORY####EMPLOYEE_ID,START_DATE,END_DATE,JOB_ID,DEPARTMENT_ID ####
			// 200,01-JUL-02,31-DEC-06,AC_ACCOUNT,90####NUMBER,DATE,DATE,VARCHAR2,NUMBER";

			String ar[] = a.split("####");

			/*
			 * System.out.println(ar[0]); System.out.println(ar[1]);
			 * System.out.println(ar[2].trim()); System.out.println(ar[3]);
			 */
			try {
				String tableName = ar[0];
				String rows[] = ar[1].split(",");
				String tableData[] = ar[2].split(",");
				String tableDataType[] = ar[3].split(",");

				String rowName = "";
				String valueName = "";
				String v = ") values (";
				String ends = "');";
				String dateTypeFlag = "";



				String aa = "insert into " + tableName + " (";

				// System.out.println(aa);

				for (int i = 0; i < rows.length; i++) {

					rowName = rowName + "," + rows[i];
					if (!tableDataType[i].equals("DATE")) {

						valueName = valueName + "','" + tableData[i].trim();

					}
					if (tableDataType[i].trim().equals("DATE")) {
						// valueName=valueName+"','"+tableData[i].trim();
						dateTypeFlag = "T";
						valueName = valueName + "',to_date('" + tableData[i].trim() + "','dd-mm-yyyy')";

						// System.out.println("substringTest-------"+valueName.substring(valueName.length()-1,
						// valueName.length()));
					}
				}

				rowName = rowName.substring(1);
				valueName = valueName.substring(2);

				String fromReplace = "\\)',to_date\\('";
				String toReplace = "\\),to_date\\('";

				// System.out.println(v + valueName);
				String query = aa + rowName + v + valueName + ends;
				// System.out.println(query);
				 masterQuery = query.replaceAll(fromReplace, toReplace);

				fromReplace = "-yyyy'\\)',";
				toReplace = "-yyyy'\\),";
				masterQuery = query.replaceAll(fromReplace, toReplace);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println(masterQuery);

		}
		//File myObj = new File("C:\\Users\\MyName\\filename.txt");
		  try {
		      File myObj = new File("Documents\fnewwwwwwww.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

	}

}
