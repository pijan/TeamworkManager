package cz.uhk.teamworkmanager.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cz.uhk.teamworkmanager.model.User;
import cz.uhk.teamworkmanager.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {
	
	Session session;
	
	public UserDAOImpl(Session s) {
		session = s;
	}
	
	@Override
	public void saveUser(User user) {
		System.out.println(session.toString());
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}

	@Override
	public List<User> listUser() {
		session.beginTransaction();
		List result = session.createCriteria(User.class).list();
	    session.getTransaction().commit();
		return result;
	    
	}

}
