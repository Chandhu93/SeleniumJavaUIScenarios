package EyProgramming;

import java.util.Set;
import java.util.TreeSet;

import org.testng.annotations.Test;

public class SecondLargestElment {
	@Test
	public void second() {
		int[] a = {1,2,3,4,5,6,7};
		
		Set<Integer> s=  new TreeSet<Integer>();
		for(int i=0; i<a.length; i++) {
			s.add(a[i]);
		}
		int count=0;
		for(int i : s) {
			if(s.size()-2 == count) {
			System.out.println(i);
			}
			count++;
		}
		
	}

}
