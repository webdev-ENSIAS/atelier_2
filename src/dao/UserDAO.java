/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import atelier_2.db.DBinteraction;
import atelier_2.model.User;

/**
 * @author Mr.SAAD
 *
 */
public class UserDAO implements IUserDAO {

	@Override
	public int addUser(User u) {
		int n = 0;
		Connection con = DBinteraction.getConnection();
		String sql = "INSERT INTO users VALUES(NULL, ? , ? , ?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, u.getUsername());
			st.setString(2, u.getEmail());
			st.setString(3, u.getPassword());
			n = st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public User login(String email, String password) {
		User u = null;
		Connection con = DBinteraction.getConnection();
		String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if(rs.next()){
				u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString("username"));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

}
