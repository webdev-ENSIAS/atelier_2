/**
 * 
 */
package atelier_2.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Mr.SAAD
 *
 */
public class DBinteraction {
	static String url = "jdbc:mysql://localhost/atelier";
	static Connection con = null;
	
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,"root","root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//etablir la connection
		 return con;
	}
	
	
	public void disconnect(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
