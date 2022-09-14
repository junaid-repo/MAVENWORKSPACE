package excelProject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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

		/*
		 * Integer i = null; Map<String, String> testMap = new HashMap<>();
		 * 
		 * JobDetails job = new JobDetails();
		 * 
		 * job.setJobId("this is the job Id");
		 * 
		 * System.out.println(job); System.out.println(job.hashCode());
		 * 
		 * CopyOnWriteArrayList<String> names = new CopyOnWriteArrayList<>();
		 * 
		 * names.add("Junaid"); names.add("King"); names.add("Raja");
		 * 
		 * Iterator<String> itr = names.iterator();
		 * 
		 * while (itr.hasNext()) { System.out.println(itr.next()); names.add("Md"); }
		 */

		List<Integer> list1 = Arrays.asList(43, 66, 45, 75, 24, 63);
		Integer sum = list1.stream().filter(x -> x % 2 == 0).reduce(0, Integer::sum);

		System.out.println(sum);

		List<String> list2 = Arrays.asList("Rowan", "Ronan", "Ronald", "Ron");

		list2.stream().filter(i -> i.startsWith("Ro")).map(i -> i.replace("Ro", "Do")).forEach(System.out::println);
	}

}
