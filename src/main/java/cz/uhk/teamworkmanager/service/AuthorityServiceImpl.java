package cz.uhk.teamworkmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.teamworkmanager.dao.AuthorityDAO;
import cz.uhk.teamworkmanager.dao.UserDAO;
import cz.uhk.teamworkmanager.model.Authority;
import cz.uhk.teamworkmanager.model.User;

@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService {
	
	@Autowired
    private AuthorityDAO authorityDAO;
        
    public void save(Authority authority) {
        authorityDAO.save(authority);
    }
    
    public void update(Authority authority){
    	authorityDAO.update(authority);    	
    }
 
    public List<Authority> list() {
        return authorityDAO.list();
    }

}
