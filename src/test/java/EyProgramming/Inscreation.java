package EyProgramming;

import org.testng.annotations.Test;

public class Inscreation {
	@Test

	public void arrayInsert() {
		int[] arr = new int[6]; 
		int n = 5;
		arr[0] = 1;
		arr[1] = 3;
		arr[2] = 5;
		arr[3] = 7;
		arr[4] = 9;

		int pos = 2; 
		int value = 4;

		for (int i = n; i > pos; i--) {
			arr[i] = arr[i - 1];
		}
		arr[pos] = value;
		n++;

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}




