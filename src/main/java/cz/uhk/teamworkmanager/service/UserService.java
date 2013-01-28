package cz.uhk.teamworkmanager.service;

import java.util.List;

import cz.uhk.teamworkmanager.model.User;

public interface UserService {
	
	public void save(User user) ;
	
	public void delete(String name);
	
	public User get(String name);
	
	public void update(User user);
	
	public List<User> list() ;

}
