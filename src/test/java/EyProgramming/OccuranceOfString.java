package EyProgramming;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class OccuranceOfString {
	@Test
	public void occ() {
		String s= "Brace for an Exploxtion";
		s=s.toLowerCase();
		String[] s1 = s.split("");
		boolean[] b= new boolean[s1.length];

		for (int i=0; i<s1.length-1; i++) {
			if(b[i]==false ) {
				int count=1;
				for(int j=i+1; j<s1.length; j++) {
					if(s1[i].equals(s1[j])) {
						count++;
						b[j]=true;
						b[i]= true;
					}
				}
				System.out.println(s1[i]+" ===> "+count);
			}
		}
	}

	@Test
	public void collectionOcc() {
		String s= "Brace for an Exploxtion";
		Map<Character, Integer> m = new HashMap();
		
		for(char ch: s.toCharArray()) {
			
			if(m.containsKey(ch)) {
				m.put(ch, m.get(ch)+1);
			} else {
				m.put(ch, 1);
			}
		}
		for(Map.Entry<Character, Integer> e: m.entrySet()) {
			System.out.println(e.getKey()+" ===> "+e.getValue());
		}
		
		
		
	}
	
}













