package partice.DDT.Vtiger;

import java.util.Random;

public class RandomNum {

	public static void main(String[] args) {
			Random ran = new Random();
			int ranNum = ran.nextInt(1000);
			System.out.println(ranNum);
	}

}
