/**
 * 
 */
package dao;

import atelier_2.model.User;

/**
 * @author Mr.SAAD
 *
 */
public interface IUserDAO {
	public int addUser(User u);
	User login(String email,String password );
	int activateUser(String token);
}
