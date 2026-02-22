package partice.DDT.Vtiger;


import org.testng.annotations.Test;

public class ReadDataFromCMDLine {

		@Test
		public void runTisme() {
			
			String bro = System.getProperty("browser");
			String uRL = System.getProperty("url");
			String un= System.getProperty("username");
			String pwd = System.getProperty("password");	
		
			System.out.println(bro);
			System.out.println(uRL);
			System.out.println(un);
			System.out.println(pwd);
			
		}
	}
