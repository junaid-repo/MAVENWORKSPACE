package excelProject;

import java.util.ArrayList;
import java.util.List;

import com.jdbcdemo.jdbcdemo.coreCall.CoreServiceCall;
import com.jdbcdemo.jdbcdemo.dto.EmployeeDetailsRequest;
import com.jdbcdemo.jdbcdemo.dto.Property;

/**
 * Hello world!
 *
 */
public class App7 {
	EmployeeDetailsRequest emp = new EmployeeDetailsRequest();
	
	

	public static void main(String[] args) {
		List<Property> propertyList = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			Property prop = new Property();
			prop.setParamName("CheckParamName");
			prop.setParamValue("checkParamValue");
			propertyList.add(prop);

		}
		
		CoreServiceCall core = new CoreServiceCall();
		core.getDocLocationWithDocId4(propertyList);
	}

}
