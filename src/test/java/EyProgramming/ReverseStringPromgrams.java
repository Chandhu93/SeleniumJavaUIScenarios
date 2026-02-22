package EyProgramming;

import org.testng.annotations.Test;

public class ReverseStringPromgrams {
	@Test
	public void lastWord() {

		String s= "Brace for an Exploxtion";
		String[] s1 = s.split(" ");

		for(int i=0; i<s1.length; i++) {
			if(i== s1.length-1) {
				String sub = s1[i];
				String  rev="";
				for(int j=sub.length()-1; j>=0; j--) {
					rev= rev+sub.charAt(j);
				}
				System.out.print(rev+" ");
			} else {
				System.out.print(s1[i]+" ");
			}
		}

	}

}
