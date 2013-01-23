package cz.uhk.teamworkmanager.dao;

import java.util.List;

import org.hibernate.Session;

import cz.uhk.teamworkmanager.model.Notice;

public class NoticeDAOImpl extends AbstractDAO implements NoticeDAO {
	
	public NoticeDAOImpl(Session s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveNotice(Notice notice) {
		session.beginTransaction();
		session.save(notice);
		session.getTransaction().commit();
	}

	@Override
	public List<Notice> listNotes() {
		session.beginTransaction();
		List result = session.createCriteria(Notice.class).list();
	    session.getTransaction().commit();
		return result;
	}
	
}
