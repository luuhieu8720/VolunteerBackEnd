package codeproject.request;

import javax.validation.constraints.*;

public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    
    @NotBlank
    @Size(min = 3, max = 30)
    private String name;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
  
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    
    @NotBlank
	@Size(min = 10, max = 11)
	private String phone;
    
	@NotBlank
	private String gender;
	
	@NotBlank
	private String date;
	
	@NotBlank
	private String role;
  
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
    
    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPassword(String password) {
        this.password = password;
    }
    
    public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}