package utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;

import com.jdbcdemo.jdbcdemo.dto.BaseOutput;
import com.jdbcdemo.jdbcdemo.dto.InsertEmployeeList;

public class Utility {

	public String changeData(ArrayList<InsertEmployeeList> arrayData, String seperator, Object ob) {

		String stringData = "";
		String tempString="";
		
		for(InsertEmployeeList empList: arrayData) {
			tempString=
					empList.getDepartmentId()+"$$"+empList.getCommisionPct();

		}

		return stringData;
	}
	
	
 
 
 public static String convertCLOBToString(java.sql.Clob clobObject) {
	 
	 String clobAsString=null;
	 
	 try {
		InputStream in = clobObject.getAsciiStream();
		 StringWriter w = new StringWriter();
		 IOUtils.copy(in, w);
		 clobAsString=w.toString();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return clobAsString;
 }
 
 public BaseOutput createAndWriteInAndWriteInAFile(String tableName, String tableQuery){
	 
	 BaseOutput output = new BaseOutput();
	 String dir = "C:\\My_Workbench\\MAVENWORKSPACE\\DATABASE\\FILES\\SCHEMA\\DEV\\TABLE_DATA_SCRIPTS\\";
	 
	 createAFile(tableName, dir);
	 witeInAFile(tableName, tableQuery, dir);
		
		
	 output.setErrorCode(0);
	 output.setErrorDesc("Success");
	 
	 return output;
	 
 }
 
 public static void createAFile(String tableName, String dir) {

		//String location = "C:\\Users\\junai\\OneDrive\\Documents\\";
		String fileName = dir + tableName + ".sql";
		System.out.println(fileName);

		try {
			File myObj = new File(fileName);
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

	public static void witeInAFile(String tableName, String tableScrpts, String dir) {

		//String location = "C:\\Users\\junai\\OneDrive\\Documents\\";
		String fileName = dir + tableName + ".sql";
		System.out.println(fileName);

		try {
			FileWriter myWriter = new FileWriter(fileName);
			myWriter.write(tableScrpts);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

 
}
