package cz.uhk.teamworkmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.teamworkmanager.dao.UserDAO;
import cz.uhk.teamworkmanager.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserDAO userDAO;
     
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }
 
    @Transactional
    public List<User> listUser() {
        return userDAO.listUser();
    }

}
