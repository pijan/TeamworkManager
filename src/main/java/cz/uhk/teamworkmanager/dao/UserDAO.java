package cz.uhk.teamworkmanager.dao;

import java.util.List;
import cz.uhk.teamworkmanager.model.User;

public interface UserDAO {

	public void saveUser(User user) ;
	public List<User> listUser() ;
	
}
