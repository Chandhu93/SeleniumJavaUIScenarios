package partice.DDT.Vtiger;

import org.testng.annotations.Test;

public class ReadRuntimeMavenParameter {
	@Test
	public void runtimeParameter() {
		
		String browser = System.getProperty("browser");
		String url = System.getProperty("url");
		String username = System.getProperty("username");
		String password = System.getProperty("password");
		
		System.out.println("browser Data------->" + browser);
		System.out.println("Env Data------->" + url);
		System.out.println("username Data------->" + username);
		System.out.println("password Data------->" + password);
		
		
		
		
	}
}

