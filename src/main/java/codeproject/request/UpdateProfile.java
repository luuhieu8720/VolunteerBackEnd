package codeproject.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UpdateProfile {
		@Size(min = 3, max = 40)
	    private String name;
	 
	    @Email
	    private String email;
	    
	  
		@Size(min = 10, max = 11)
		private String phone;
	    
		
	
		private String date;
		
	
		private String address;
		
		private String avatar;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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
	  
		
}
