package Backend;

public class User {
	
	private String username;
	private String password;
	private String userType;
	
	public User(String username, String password, String userType) {
		this.username = username;
		this.password = password;
		this.userType = userType;
	}

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }
	

}
