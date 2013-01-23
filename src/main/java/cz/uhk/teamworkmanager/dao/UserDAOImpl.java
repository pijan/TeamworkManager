package cz.uhk.teamworkmanager.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.teamworkmanager.model.User;

@Repository
@Transactional //???
public class UserDAOImpl implements UserDAO {
	
	//@Autowired
    private SessionFactory sf;
	
	public void saveUser(User user) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().save(user);
		sf.getCurrentSession().getTransaction().commit();
	}

	public List<User> listUser() {
		sf.getCurrentSession().beginTransaction();
		List result = sf.getCurrentSession().createCriteria(User.class).list();
		sf.getCurrentSession().getTransaction().commit();
		return result;
	}

}
