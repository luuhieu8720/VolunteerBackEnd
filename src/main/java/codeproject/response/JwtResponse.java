package codeproject.response;



public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String name;

	private Long id;

	private String username;

	private String email;
	
	private String phone;
	
	private String date;
	
	private String role;
	
	private String address;
	
	private String avatar;
	
	private boolean active;
	
	private String gender;
	public JwtResponse(String name) {	
		this.name = name;
	}
	public JwtResponse(String accessToken,String username, Long id,String role) {
		this.token = accessToken;
		this.username = username;
		this.id = id;
		this.role = role;	
		
	}
	public JwtResponse(String name,String username,String phone,String address,String role,boolean active) {
		this.name = name;
		this.username = username;
		this.phone = phone;
		this.address = address;
		this.role = role;	
		this.active = active;
		
	}
	public JwtResponse(String name,String username,String email,String phone,String date, String address,String avatar,String role,String gender){
		this.name = name;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.date = date;
		this.address = address;
		this.avatar = avatar;
		this.role = role;
		this.gender = gender;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	
	
	
}