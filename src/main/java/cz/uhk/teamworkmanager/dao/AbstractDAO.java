package cz.uhk.teamworkmanager.dao;

import org.hibernate.Session;

/*
 * 
 * 	
 * 	NECHÁPU SMYSL TÉTO TŘÍDY, SESSION JE NYNÍ AUTOWIRED, SMAZAT?
 * 
 * 
 */

public class AbstractDAO {

	Session session;
	
	public AbstractDAO(Session s) {
		session = s;
	}
	
}
