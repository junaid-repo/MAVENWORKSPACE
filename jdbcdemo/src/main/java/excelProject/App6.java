package excelProject;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.jdbcdemo.jdbcdemo.dto.EmployeeDetailsRequest;

/**
 * Hello world!
 *
 */
public class App6 implements Runnable {
	EmployeeDetailsRequest emp = new EmployeeDetailsRequest();

	public App6(EmployeeDetailsRequest empNew) {
		// empNew.setDeptId("35253059");
		emp = empNew;
	}

	public void run() {

		System.out.println(emp.getDeptId());
	}

	public static void main(String[] args) {

		EmployeeDetailsRequest empNew = new EmployeeDetailsRequest();
		empNew.setDeptId("9923893");
		App6 obj = new App6(empNew);

		Thread thread = new Thread(obj);
		thread.start();

	}

}
