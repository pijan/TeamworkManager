package cz.uhk.teamworkmanager.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import cz.uhk.teamworkmanager.model.User;

public interface UserDAO extends UserDetailsService {

	public void saveUser(User user) ;
	public List<User> listUser() ;
	
}
