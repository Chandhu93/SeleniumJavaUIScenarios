package EyProgramming;

import org.testng.annotations.Test;

public class FibnacciSeries {
	@Test
	public void series() {

		int a=0; 
		int b=1;
		System.out.print(a+", "+b+", ");

		for(int i=0; i<=5; i++) {
			int sum= a+b;
			System.out.print(sum+", ");
			a= b;
			b=sum;
		}
	}
}
