package com.agrovetel.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import com.agrovetel.domain.Role;
import com.agrovetel.domain.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * Class for implementind UserDetails interface
 * 
 * @author csabe812
 *
 */
public class UserDetailsImpl implements UserDetails {
	/**
	 * Generated serialization id
	 */
	private static final long serialVersionUID = -6155382268720572383L;
	private User user;

	/**
	 * Constructor for initializing a user
	 * 
	 * @param user
	 */
	public UserDetailsImpl(User user) {
		this.user = user;
	}

	/**
	 * Implemented interface
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		Set<Role> roles = user.getRoles();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return authorities;
	}

	/**
	 * Implemented interface
	 */
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	/**
	 * Implemented interface
	 */
	@Override
	public String getUsername() {
        //System.out.println("email: ");
        //System.out.println(user.getEmail());
		return user.getEmail();
	}

	/**
	 * Implemented interface
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * Implemented interface
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * Implemented interface
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * Implemented interface
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}
}
