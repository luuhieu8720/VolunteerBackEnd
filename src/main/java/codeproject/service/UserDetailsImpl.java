package codeproject.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import codeproject.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;



public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private String name;

	private Long id;

	private String username;

	private String email;
	
	private String phone;
	
	private String gender;
	
	private String date;
	
	private String role;
	
	private String address;
	
	private String avatar;
	
	private boolean active;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id,String name, String username, String email, String password, String phone, String gender,String date,
			String role,String address,String avatar,boolean active,Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.gender = gender;
		this.date = date;
		this.role = role;
		this.address = address;
		this.avatar = avatar;
		this.active = active;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getId(), 
				user.getName(),
				user.getUsername(), 
				user.getEmail(),
				user.getPassword(), 
				user.getPhone(),
				user.getGender(),
				user.getDate(),
				user.getRole(),
				user.getAddress(),
				user.getAvatar(),
				user.getActive(),
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getGender() {
		return gender;
	}
	public String getDate() {
		return date;
	}
	public String getRole() {
		return role;
	}
	public String getAddress() {
		return address;
	}
	public String getAvatar() {
		return avatar;
	}
	
	public boolean getActive() {
		return active;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}