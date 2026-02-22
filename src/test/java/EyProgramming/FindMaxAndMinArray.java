package EyProgramming;

import org.testng.annotations.Test;

public class FindMaxAndMinArray {

	@Test
	public void maxAndMin() {
		int[] a= {2,-6,6,8,0,4,5,7,88,99,45,46,44};
		int min= a[0]; 
		int max=a[0];
		
		for(int i=0; i<a.length; i++) {
			if(a[i] > max)
				max = a[i];
			else if(a[i] < min)
				min = a[i];
		}
		System.out.println("Max: "+max);
		System.out.println("Min: "+min);
		
		
	}
	
}
