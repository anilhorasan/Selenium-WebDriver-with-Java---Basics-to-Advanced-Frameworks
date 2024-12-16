package DatabaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JavaDatabaseConnection {

	public static void main(String[] args) throws SQLException {

		String host = "localhost";
		String port = "3306";
		String dbName = "qadbt";
		String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
		String username = "root";
		String password = "7412956";
		
		Connection con = DriverManager.getConnection(url, username, password);
		
		Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM EmployeeInfo WHERE id = 2");

        // Move cursor to the first row
        if (rs.next()) {
            // Access the "age" column value
            System.out.println("age: " + rs.getInt("age")); // Use getInt for age as it's an integer
            System.out.println("name: " + rs.getString("name")); // Use getInt for age as it's an integer
            System.out.println("location: " + rs.getString("location")); // Use getInt for age as it's an integer
        } else {
            System.out.println("No data found for the given query.");
        }

        // Close connections
        rs.close();
        s.close();
        con.close();
		
		

	}

}
