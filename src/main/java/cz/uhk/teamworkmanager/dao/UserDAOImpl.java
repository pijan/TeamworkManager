package cz.uhk.teamworkmanager.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.teamworkmanager.model.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		  
		username = (username == null) ? "" : username;
                     
        Query query = sessionFactory.getCurrentSession().createQuery("from User where username=:username");
        query.setParameter("username", username);  
        
        List<User> results = query.list();
        
        return (UserDetails) results.get(0);
        
	}	
	
	public void saveUser(User user) {
		
		sessionFactory.getCurrentSession().save(user);
		
	}

	public List<User> listUser() {
		
		List result = sessionFactory.getCurrentSession().createCriteria(User.class).list();
		return result;
		
	}

}
