package cz.uhk.teamworkmanager.service;

import java.util.List;

import cz.uhk.teamworkmanager.model.User;

public interface UserService {
	
	public void saveUser(User user) ;
	public List<User> listUser() ;

}
