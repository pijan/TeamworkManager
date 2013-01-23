package cz.uhk.teamworkmanager.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	private HibernateUtil() {
	}
	
	//HibernateUtil.getSessionFactory().openSession()
	
	public static void initSessionFactory() {
		try{
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}catch (Exception e) {
			System.out.println("Error during creating SessionFactory!");
			e.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null){
			initSessionFactory();
		}
		return sessionFactory;
	}

	public static void shutdown(){
		sessionFactory.close();
	}
}
