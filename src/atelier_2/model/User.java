/**
 * 
 */
package atelier_2.model;

/**
 * @author Mr.SAAD
 *
 */
public class User {
	private int id;
	private String username;
	private String email;
	private String password;
	private int isValidated;
	private String token ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String email, String password , int isValidated, String token) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.isValidated = isValidated;
		this.token = token;
	}
	
	
	public int getIsValidated() {
		return isValidated;
	}
	public void setIsValidated(int isValidated) {
		this.isValidated = isValidated;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + "]";
	}
	
}
