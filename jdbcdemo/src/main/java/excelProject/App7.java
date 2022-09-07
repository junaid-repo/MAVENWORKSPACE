package excelProject;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import com.jdbcdemo.jdbcdemo.dto.EmployeeDetailsRequest;
import com.jdbcdemo.jdbcdemo.dto.JobDetails;

/**
 * Hello world!
 *
 */
public class App7 {
	EmployeeDetailsRequest emp = new EmployeeDetailsRequest();

	public static void main(String[] args) {
		
		JobDetails job = new JobDetails();
		
		job.setJobId("this is the job Id");
		
		System.out.println(job);
		System.out.println(job.hashCode());
		
		CopyOnWriteArrayList<String> names = new CopyOnWriteArrayList<>();
		
		names.add("Junaid");
		names.add("King");
		names.add("Raja");
		
		Iterator<String> itr = names.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
			names.add("Md");
		}
		
		
	}

}
