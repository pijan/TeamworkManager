package cz.uhk.teamworkmanager.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.uhk.teamworkmanager.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
    UserService userService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPage(HttpServletRequest request, Model model) {
		
		// nastavuje atribut do sablony, aby zobrazila chybovou hlasku
		if(request.getParameter("login_error") != null) model.addAttribute("error", true);
		        
		return "login"; 
		
		
	}
	
}
