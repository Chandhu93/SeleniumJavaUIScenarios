package partice.DDT.Vtiger;

public class GenerateAlphaNumeric {

	public static void main(String[] args) {
		int n=20;
		String alphaNumric = "ABDCEFGHIJKLMNONPRSTUVWXYZ1234567890abcdefghijklmnoprstuvwxyz";
		StringBuilder sb  = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			int index= (int) (alphaNumric.length()*Math.random());
			sb.append(alphaNumric.charAt(index));
		}
		
		System.out.println(sb);
		
	}
}
