package utility;

import java.util.ArrayList;

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
	
	

}