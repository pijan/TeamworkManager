package cz.uhk.teamworkmanager.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
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
		  
		System.out.println("hledam hledam .... ");
		username = (username == null) ? "" : username;
        System.out.println(username);
     
        
        Query query = sessionFactory.getCurrentSession().createQuery("from users where login=:username");
        query.setParameter("username", username);  
        List<User> results = query.list();
        
        
        System.out.println("neco jsme nasli");
        
        return (UserDetails) null;
        
        /*
        System.out.println("vysledek");
        System.out.println(results.size());

	    for ( User usr : (List<User>) results ) {
			System.out.println( "Nalezeny (" + usr.getName() + ") : " + usr.getLogin() );
		}

        if (results.size() < 1) {
        	System.out.println("Uzivatel nenalezen");
        	throw new UsernameNotFoundException(username + "not found");
        }
    
        return (UserDetails) results.get(0);*/
	}	
	
	
	public void saveUser(User user) {
		//sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().save(user);
		//sessionFactory.getCurrentSession().getTransaction().commit();
	}

	public List<User> listUser() {
		//sessionFactory.getCurrentSession().beginTransaction();
		List result = sessionFactory.getCurrentSession().createCriteria(User.class).list();
		//sessionFactory.getCurrentSession().getTransaction().commit();
		return result;
	}

}
