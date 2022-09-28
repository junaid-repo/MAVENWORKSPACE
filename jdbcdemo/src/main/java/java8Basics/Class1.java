package java8Basics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.jdbcdemo.jdbcdemo.dto.PincodeDetails2;

public class Class1 {

	public static void main(String[] args) {
		List<String> st = List.of("Junaid", "khan", "is", "the", "number", "1");
		PincodeDetails2 pd = new PincodeDetails2();

		pd.setCircle("ddd");
		pd.setDelivery("ccc");
		// pd.office = "tiit";
		List<PincodeDetails2> objectList = new ArrayList<>();
		objectList.add(pd);

		List<String> st2 = new ArrayList<>();
		st2 = st.stream().filter(i -> i.contains("a")).collect(Collectors.toList());
		System.out.println(st2);

		objectList.stream().filter(p -> p.getCircle().contains("d")).forEach(System.out::println);

	}

}
