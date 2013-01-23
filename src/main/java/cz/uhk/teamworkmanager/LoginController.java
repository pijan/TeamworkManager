package cz.uhk.teamworkmanager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.uhk.teamworkmanager.dao.UserDAO;
import cz.uhk.teamworkmanager.dao.UserDAOImpl;
import cz.uhk.teamworkmanager.model.User;
import cz.uhk.teamworkmanager.util.HibernateUtil;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	
	UserDAOImpl userDAO = new UserDAOImpl(this.session);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String notebookList(HttpServletRequest request, Model model) {
		
		// nastavuje atribut do sablony, aby zobrazila chybovou hlasku
		if(request.getParameter("login_error") != null) model.addAttribute("error", true);
		
		//vložení uživatelů do DB
		User u = new User( "Michal Klapal", "michal", "password", 7, 1, "michalklapal@gmail.com");
		userDAO.saveUser(u);
		//session.beginTransaction();
		//session.save(u);
		//session.getTransaction().commit();
		
		//session.beginTransaction();
		//List result = session.createCriteria(User.class).list();
		List result = userDAO.listUser();
		
		for ( User usr : (List<User>) result ) {
			System.out.println( "User (" + usr.getName() + ") : " + usr.getLogin() );
		}
        //session.getTransaction().commit();
        
        //je vůbec nutné?
        HibernateUtil.shutdown();
        
		return "login"; 
		
		
	}
	
}
