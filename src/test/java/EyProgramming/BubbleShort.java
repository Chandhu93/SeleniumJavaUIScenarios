package EyProgramming;

import org.testng.annotations.Test;

public class BubbleShort {
	@Test
	public void bubbleShort() {
		int[] a= {2,-6,6,8,0,4,5,7,88,99,45,46,44};

		for (int i=0; i<a.length-1; i++) {
			for(int j=i+1; j<a.length-1; j++) {
				if(a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i]+", ");

		}




	}

}
