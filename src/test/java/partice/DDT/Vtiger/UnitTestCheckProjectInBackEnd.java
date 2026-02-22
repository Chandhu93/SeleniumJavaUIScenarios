package partice.DDT.Vtiger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class UnitTestCheckProjectInBackEnd {
	
	@Test
	
	public void projectCheck() throws SQLException {
		
		Connection con = null;
		String expectedProjectName = "";
		Boolean flag = false;

		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);

		con = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");

		Statement stat = con.createStatement();

		ResultSet resultSet = stat.executeQuery("select * from project");
		
		while(resultSet.next()) {
			String actProjectName = resultSet.getString(4);
			if(expectedProjectName.equals(actProjectName)) {
				flag = true;
				System.out.println(expectedProjectName + " is PASS");
			}
		}
		
		if(flag == false) {
			System.out.println(expectedProjectName + " is PASS");
			Assert.fail();
		}	
		con.close();
			
		}
	}

















