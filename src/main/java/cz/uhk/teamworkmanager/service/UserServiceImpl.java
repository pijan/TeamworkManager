package cz.uhk.teamworkmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import cz.uhk.teamworkmanager.dao.UserDAO;
import cz.uhk.teamworkmanager.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserDAO userDAO;
        
    public void save(User user) {
        userDAO.saveUser(user);
    }
 
    public void delete(String name){
    	userDAO.deleteUser(name);
    }
    
    public User get(String name){
    	return (User) userDAO.loadUserByUsername(name);
    }
    
    public void update(User user){
    	userDAO.updateUser(user);
    }
    
    public List<User> list() {
        return userDAO.listUser();
    }

}
