package cz.uhk.teamworkmanager.dao;

import org.hibernate.Session;

public class AbstractDAO {

	Session session;
	
	public AbstractDAO(Session s) {
		session = s;
	}
	
}
