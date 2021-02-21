package com.example.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.security.model.Role;
import com.example.security.model.User;

//MyUserDetailsService will get the details from this class
public class UserDetailsImpl implements UserDetails{

	private User user;
	
	public UserDetailsImpl(User user) {
		this.user = user;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> auth = new HashSet<>();
		// TODO Auto-generated method stub
		
		for (Role role: user.getRoles()) {
			auth.add(new SimpleGrantedAuthority(role.getName()));
		}
		return auth;
	}
	
	public int getID() {
		return user.getId();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	

}
