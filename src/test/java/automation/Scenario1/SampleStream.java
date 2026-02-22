package automation.Scenario1;

import java.util.Arrays;

public class SampleStream {
	public static void main(String[] args) {
		int [] a= {3,4,7,9,1,2,-1, 2,3};
		int [] b= Arrays.stream(a).sorted().toArray();
		int [] c= Arrays.stream(a).distinct().toArray();
		int [] d= Arrays.stream(a).distinct().sorted().toArray();
		int []e= Arrays.stream(a).filter(i -> i%2 ==0).toArray();
		
		System.out.println(Arrays.toString(b)+" sorted Array");
		System.out.println(Arrays.toString(c)+" unique");
		System.out.println(Arrays.toString(d)+" unique shorted ");
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(e)+" only even index element");
		
	}

}
