package cz.uhk.teamworkmanager.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.uhk.teamworkmanager.dao.UserDAO;
import cz.uhk.teamworkmanager.dao.UserDAOImpl;
import cz.uhk.teamworkmanager.model.User;
import cz.uhk.teamworkmanager.service.UserService;
import cz.uhk.teamworkmanager.util.HibernateUtil;
import cz.uhk.teamworkmanager.util.MyBeanClass;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	
	@Autowired
    UserService userService;
	
	@Autowired
    MyBeanClass m;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String notebookList(HttpServletRequest request, Model model) {
		
		// nastavuje atribut do sablony, aby zobrazila chybovou hlasku
		if(request.getParameter("login_error") != null) model.addAttribute("error", true);
		
		//vložení uživatelů do DB
		User u = new User( "Michal Klapal", "michal", "password", 7, 1, "michalklapal@gmail.com");
		userService.saveUser(u);
		//session.beginTransaction();
		//userService.saveUser(u);
		//session.getTransaction().commit();
		
		//session.beginTransaction();
		//List result = session.createCriteria(User.class).list();
		List result = userService.listUser();
		
		System.out.println("Uzivatele:");
		
		for ( User usr : (List<User>) result ) {
			System.out.println( "User (" + usr.getName() + ") : " + usr.getLogin() );
		}
				
        //session.getTransaction().commit();
        
        //je vůbec nutné?
        //HibernateUtil.shutdown();
        
        //ApplicationContext ctx = new ClassPathXmlApplicationContext();
        //ApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
        //MyBeanClass m = ctx.getBean(MyBeanClass.class);
        //System.out.println(m.getAbc());
        
        System.out.println(m.getAbc());
        
		return "login"; 
		
		
	}
	
}
