package partice.DDT.Vtiger;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public class ExecuteSelectQuery {

	public static void main(String[] args) throws SQLException {
		Connection con= null;
		try {
			//step1: load/register the database driver from mysql.jdbc.Driver
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);

			//step2: connect to database
			con = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");

			//step3: create sql statement
			Statement stat = con.createStatement();

			// step4 : execute select query and get result
			ResultSet result = stat.executeQuery("select * from project;");
			while(result.next()) {
				System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"
						+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getInt(6));
			}
		}
		catch(Exception e) {
			System.out.println("Exception is handled");
		}
		finally {
		//step5: close connection
		con.close();
		
		}
	}

}
