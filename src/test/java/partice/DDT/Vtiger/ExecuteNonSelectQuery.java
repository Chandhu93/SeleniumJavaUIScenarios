package partice.DDT.Vtiger;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQuery {

	public static void main(String[] args) throws SQLException {
		Connection con = null;

			//step1: load/register the database driver from mysql.jdbc.Driver
			Driver driverRef = new Driver();
//			DriverManager.registerDriver(driverRef);

			//step2: connect to database
			con = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");

			//step3: create sql statement
			Statement stat = con.createStatement();

			// step4 : execute select query and get result
			int result = stat.executeUpdate("insert into project values('KP_309876','chandhu','04/05/2025','KPIT_033','on_Going','0');");
			System.out.println(result);
	
			con.close();

		

	}
}
