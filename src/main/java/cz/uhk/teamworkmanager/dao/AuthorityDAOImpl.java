package cz.uhk.teamworkmanager.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.teamworkmanager.model.Authority;
import cz.uhk.teamworkmanager.model.Notice;

@Repository
@Transactional
public class AuthorityDAOImpl implements AuthorityDAO {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	
	@Override
	public void save(Authority authority) {
		sessionFactory.getCurrentSession().save(authority);

	}
	public void update(Authority authority){
		sessionFactory.getCurrentSession().update(authority);
	}
	
	@Override
	public List<Authority> list() {

		List<Authority> result = sessionFactory.getCurrentSession().createCriteria(Authority.class).list();
		return result;
		
	}
	
}
