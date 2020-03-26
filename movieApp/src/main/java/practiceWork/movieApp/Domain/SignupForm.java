package practiceWork.movieApp.Domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SignupForm {
	
	@NotEmpty
	@Size(min=5, max=30, message="Username must be atleast 5 characters")
	private String username = "";
	
	@NotEmpty
	@Size(min=7, max=30)
	private String email = "";
	
	@NotEmpty
	@Size(min=7, max=30, message="Password must be atleast 7 characters")
	private String password = "";
	
	@NotEmpty
	@Size(min=5, max=30, message="Passwords doesn't match")
	private String passwordCheck = "";
	
	@NotEmpty
	private String role = "USER";

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

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
		

}
