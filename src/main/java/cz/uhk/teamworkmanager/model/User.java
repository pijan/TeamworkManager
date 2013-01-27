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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table( name = "users" )
public class User implements Serializable, UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	String username;
	String password;
	int enabled;
	
	@OneToOne
    @JoinColumn(name="username")
    private Authority authority;
	
	public User(){
		
	}
	
	public User(String username, String password, int enabled){
		this.username = username;
		this.password = password;
		this.enabled = enabled;
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
	
	
	public List<GrantedAuthority> setAuthorities(List<Authority> auths) { 
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(); 
		
		for (Authority auth : auths) grantedAuthorities.add((GrantedAuthority) new GrantedAuthorityImpl(auth.getUsername())); 
		
		return grantedAuthorities; 
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		
		grantedAuthorities.add(new GrantedAuthorityImpl(this.authority.getAuthority()));
		
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
	
	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
	
}
