package cz.uhk.teamworkmanager.web;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import cz.uhk.teamworkmanager.model.BasicGroup;
import cz.uhk.teamworkmanager.model.ExtendedGroup;
import cz.uhk.teamworkmanager.model.Authority;
import cz.uhk.teamworkmanager.model.Notice;
import cz.uhk.teamworkmanager.model.User;
import cz.uhk.teamworkmanager.service.AuthorityService;
import cz.uhk.teamworkmanager.service.NoticeService;
import cz.uhk.teamworkmanager.service.UserService;
import cz.uhk.teamworkmanager.util.FlashMessage;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
    UserService userService;
	@Autowired
	AuthorityService authorityService;
	

	@RequestMapping(value = "/action/addUser", method = RequestMethod.POST)
	public String addUserAction(/*@ModelAttribute("usersNew")*/@Validated({ExtendedGroup.class}) User user, BindingResult result, final RedirectAttributes redirectAttrs) {
				
		if (result.hasErrors()) {
			System.out.println("FOUND "+result.getErrorCount()+" ERRORS");
			System.out.println(result.getFieldErrors().toString());
			
			redirectAttrs.addFlashAttribute("FlashMessage", new FlashMessage(FlashMessage.MESSAGE_ERROR, "Odeslaný formulář nesplňuje validační podmínky"));
		    return "redirect:/users/";
		  }
		
		Authority auth = new Authority(user.getUsername(), ((Authority)result.getFieldValue("authority")).getAuthority());
		
		PasswordEncoder encoder = new Md5PasswordEncoder();
		user.setPassword(encoder.encodePassword(user.getPassword(), null));
		user.setEnabled((result.getFieldValue("enabled").toString() == "true") ? 1 : 0);
		
		try{
			userService.save(user); 
			authorityService.save(auth);
			redirectAttrs.addFlashAttribute("FlashMessage", new FlashMessage(FlashMessage.MESSAGE_OK, "Uživatel " + user.getName() + " byl úspěšně přidán"));
		}
		catch(Exception e){
			redirectAttrs.addFlashAttribute("FlashMessage", new FlashMessage(FlashMessage.MESSAGE_ERROR, "Došlo k chybě, uživatele se nepodařilo řádně přidat"));
		}
		
		return "redirect:/users/";
	}
	
	@RequestMapping(value = "/action/editUser", method = RequestMethod.POST)
	public String editUserAction(/*@ModelAttribute("usersEdit") User user,*/ @Validated({BasicGroup.class}) User user, BindingResult result, final RedirectAttributes redirectAttrs) {
		
		if (result.hasErrors()) {
			System.out.println("FOUND "+result.getErrorCount()+" ERRORS");
			System.out.println(result.getFieldErrors().toString());
			
			redirectAttrs.addFlashAttribute("FlashMessage", new FlashMessage(FlashMessage.MESSAGE_ERROR, "Odeslaný formulář nesplňuje validační podmínky"));
			
		    return "redirect:/users/edit/"+user.getUsername();
		  }
		  
		Authority auth = new Authority(user.getUsername(), ((Authority)result.getFieldValue("authority")).getAuthority());
				
		if (user.getPassword() != ""){
			PasswordEncoder encoder = new Md5PasswordEncoder();
			user.setPassword(encoder.encodePassword(user.getPassword(), null));
		}else{
			user.setPassword(userService.get(user.getUsername()).getPassword());
		}
		
		user.setEnabled((result.getFieldValue("enabled").toString() == "true") ? 1 : 0);
		
		try{
			userService.update(user); 
			authorityService.update(auth);
			redirectAttrs.addFlashAttribute("FlashMessage", new FlashMessage(FlashMessage.MESSAGE_OK, "Uživatel " + user.getUsername() + " byl úspěšně upraven"));
		}
		catch(Exception e){
			redirectAttrs.addFlashAttribute("FlashMessage", new FlashMessage(FlashMessage.MESSAGE_ERROR, "Došlo k chybě, uživatele se nepodařilo řádně upravit"));
		}
		
		return "redirect:/users/";
	}
			
	
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView add(Model model) {
		
		return new ModelAndView("usersNew", "command", new User());	
		 
	}
	
	
	
	@RequestMapping(value = "/edit/{name}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable String name, Model model) {
		
		User u = userService.get(name);
		 		
		return new ModelAndView("usersEdit", "command", u);
	}
	
	
	
	@RequestMapping(value = "/del/{name}", method = RequestMethod.GET)
	public String delete(@PathVariable String name, Model model, final RedirectAttributes redirectAttrs) {
		
		try{
			userService.delete(name);
			redirectAttrs.addFlashAttribute("FlashMessage", new FlashMessage(FlashMessage.MESSAGE_OK, "Uživatel " + name + " byl úspěšně smazán"));
		}
		catch(Exception e){
			redirectAttrs.addFlashAttribute("FlashMessage", new FlashMessage(FlashMessage.MESSAGE_ERROR, "Došlo k chybě, uživatele se nepodařilo řádně smazat"));
		}
				
		return "redirect:/users/";
	}
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String userList(@ModelAttribute("FlashMessage") final FlashMessage flashMessage, Model model) {
		
		List<User> result = userService.list();
		 
		model.addAttribute("userList", result);
		model.addAttribute("flashMessage", flashMessage); 
				
		return "users"; 
	} 
	
}
