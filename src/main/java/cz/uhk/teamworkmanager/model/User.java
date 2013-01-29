package cz.uhk.teamworkmanager.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import cz.uhk.teamworkmanager.web.UsersController;

@Entity
@Table( name = "users" )
public class User implements Serializable, UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotEmpty(groups = {BasicGroup.class, ExtendedGroup.class})
    @Size(min = 1, max = 20, groups = {BasicGroup.class, ExtendedGroup.class})
	private String username;
	
	@NotEmpty(groups = {ExtendedGroup.class})
    @Size(min = 1, max = 32,groups = {ExtendedGroup.class})
	private String password;
	
	private int enabled;
	
	private String name;
	private String surname;
	
	@NotEmpty(groups = {BasicGroup.class, ExtendedGroup.class})
	private String email;
	
	@NotEmpty
    private String authority;
	
	public User(){
		
	}
	
	public User(String username, String password, String email){
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = 1;
	}
	
	public User(String username, String password, String name, String surname, String email){
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.enabled = 1;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEnabled() {
		return enabled;
	}
	
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String toString(){
		return "User: " 
				+ this.getUsername() + ", "
				+ this.getPassword() + ", "
				+ this.getEnabled() + "\n";
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		
		grantedAuthorities.add(new GrantedAuthorityImpl(this.getAuthority()));
		
		return grantedAuthorities; 
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
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
