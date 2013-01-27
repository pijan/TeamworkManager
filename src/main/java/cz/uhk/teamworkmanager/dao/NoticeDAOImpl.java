package cz.uhk.teamworkmanager.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.teamworkmanager.model.Notice;

@Repository
@Transactional
public class NoticeDAOImpl implements NoticeDAO {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	
	@Override
	public void saveNotice(Notice notice) {
		
		sessionFactory.getCurrentSession().save(notice);

	}

	@Override
	public List<Notice> listNotes() {

		List<Notice> result = sessionFactory.getCurrentSession().createCriteria(Notice.class).list();
		return result;
		
	}
	
}
