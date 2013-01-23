package cz.uhk.teamworkmanager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import cz.uhk.teamworkmanager.model.User;
import cz.uhk.teamworkmanager.util.HibernateUtil;
import cz.uhk.teamworkmanager.util.MyBeanClass;

/**
 * Tato trida je predkem vsech controlleru, ale vyhledem k existenci interceptoru asi nebude potreba.
 */

@Controller
public class BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
		
	//@Autowired
	//HibernateUtil session;
	
	public void init(Model model){
		logger.info("To je fičák, panečku!");
		
	}
}
