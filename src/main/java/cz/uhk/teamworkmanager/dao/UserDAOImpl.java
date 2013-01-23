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
	
	@Autowired
    private SessionFactory sessionFactory;
	
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
