package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BasketDBConnect {

	public static Connection getConnect() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/basket", "root", "");
		
		return con;
	}
}
