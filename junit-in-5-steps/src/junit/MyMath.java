package junit;

import java.util.List;

public class MyMath {
	int findSum(List<Integer> numbers) {
		int sum=0;
		
		for(int num: numbers) {
			sum=sum+num;
		}
		
		return sum;
	}

}
